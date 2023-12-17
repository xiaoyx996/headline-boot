package com.phil.headline.controller;

import com.phil.headline.common.Result;
import com.phil.headline.pojo.NewsHeadline;
import com.phil.headline.service.NewsHeadlineService;
import com.phil.headline.utils.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Admin
 * @version 1.0
 * @description TODO
 * @create 2023/11/23 17:20
 */
@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("headline")
public class NewsHeadlineController{
    @Autowired
    private NewsHeadlineService newsHeadlineService;


    @PostMapping("publish")
    public Result publish(@RequestBody NewsHeadline newsHeadline, @RequestHeader String token){
        // 1.通过token获取发布者的uid
        Long userId = JwtHelper.getUserId(token);
        // 2.设置headline的信息
        newsHeadline.setPublisher(userId.intValue());
        // 3.发布，存入数据库
        newsHeadlineService.addNewsHeadline(newsHeadline);
        // 4.响应结果给客户端
        return Result.ok(null);
    }

    @PostMapping("findHeadlineByHid")
    public Result findHeadlineByHid(@RequestParam Integer hid){
        NewsHeadline newsHeadline = newsHeadlineService.findHeadlineByHid(hid);
        Map<String, NewsHeadline> headlineMap = new HashMap<>();
        headlineMap.put("headline", newsHeadline);
        Result result = Result.ok(headlineMap);
        return result;
    }

    @PostMapping("update")
    public Result update(@RequestBody NewsHeadline newsHeadline){
        newsHeadlineService.update(newsHeadline);
        return Result.ok(null);
    }

    @PostMapping("removeByHid")
    public Result removeByHid(@RequestParam Integer hid){
        int count = newsHeadlineService.removeByHid(hid);
        return Result.ok(null);
    }
}
