package com.phil.headline.controller;

import com.phil.headline.common.Result;
import com.phil.headline.common.ResultCodeEnum;
import com.phil.headline.pojo.NewsUser;
import com.phil.headline.service.NewsUserService;
import com.phil.headline.utils.JwtHelper;
import com.phil.headline.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Admin
 * @version 1.0
 * @description TODO
 * @create 2023/11/23 11:16
 */
@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("user")
public class NewsUserController{
    @Autowired
    private NewsUserService newsUserService;

    @PostMapping("login")
    public Result login(@RequestBody NewsUser loginUser){
        // 1.拿到登录信息

        // 2.去数据库中根据用户名查询记录
        NewsUser dbUser = newsUserService.selectByUsername(loginUser.getUsername());

        Result result = null;
        // 3.如果dbUser不为空，说明该用户存在
        if(dbUser != null){
            if(dbUser.getUserPwd().equals(MD5Util.encrypt(loginUser.getUserPwd()))){//密码正确，登录成功
                String token = JwtHelper.createToken(dbUser.getUid().longValue());
                Map<String, String> map = new HashMap<>();
                map.put("token", token);
                result = Result.ok(map);
            }
            else{//密码错误
                result = Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
            }
        }
        else{// 用户名不存在
            result = Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }

        // 4.返回登录结果
        return result;
    }

    @GetMapping("getUserInfo")
    public Result getUserInfo(@RequestHeader String token){
        Result result = Result.build(null, ResultCodeEnum.NOTLOGIN);;
        // 判断token是否可用
        if(token != null && (!JwtHelper.isExpiration(token))){// 没过期
            // 根据token获得用户的uid
            long uid = JwtHelper.getUserId(token);
            // 根据uid去数据库中查询该用户的信息
            NewsUser dbUser = newsUserService.selectByUserId((int)uid);
            if(dbUser != null){
                // 将密码清空
                dbUser.setUserPwd("");
                // 将用户信息以键值对的形式存入result中
                Map<String, NewsUser> map = new HashMap<>();
                map.put("loginUser", dbUser);
                result = Result.ok(map);
            }
        }
        return result;
    }

    @PostMapping("checkUserName")
    public Result checkUserName(@RequestParam String username){
        NewsUser dbUser = newsUserService.selectByUsername(username);
        Result result = null;
        if(dbUser == null){// 用户名未被占用
            result = Result.ok(null);
        }else{// 用户名被占用
            result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        return result;
    }


    @PostMapping("regist")
    public Result regist(@RequestBody NewsUser registUser){
        registUser.setUserPwd(MD5Util.encrypt(registUser.getUserPwd()));
        int count = newsUserService.addUser(registUser);
        Result result = null;
        if(count > 0){// 注册成功
            result = Result.ok(null);
        }
        else{// 注册失败，用户名被占用了
            result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        return result;
    }


    @GetMapping("checkLogin")
    public Result checkLogin(@RequestHeader String token){
        Result  result =Result.build(null,ResultCodeEnum.NOTLOGIN);
        if(null!= token){
            if (!JwtHelper.isExpiration(token)) {
                result=Result.ok(null);
            }
        }
       return result;
    }

    @GetMapping("test")
    public void test(){
        System.out.println(1/0);
    }
}
