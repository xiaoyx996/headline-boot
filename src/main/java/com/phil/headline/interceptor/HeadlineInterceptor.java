package com.phil.headline.interceptor;

import com.phil.headline.common.Result;
import com.phil.headline.common.ResultCodeEnum;
import com.phil.headline.utils.JwtHelper;
import com.phil.headline.utils.WebUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Admin
 * @version 1.0
 * @description TODO
 * @create 2023/12/12 14:03
 */
public class HeadlineInterceptor implements HandlerInterceptor {

    // 检查用户是否登录
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getMethod().equalsIgnoreCase("OPTIONS")){// 跨域请求，直接放行
            return true;
        }
        String token = request.getHeader("token");
        boolean flag = false;
        if(null != token){
            if(!JwtHelper.isExpiration(token)){
                flag = true;
            }
        }
        if(flag){// 登录验证通过
           return true;
        }
        else{ // 登录验证未通过
            System.out.println("token: "+ token);
            System.out.println("用户未登录！");
            WebUtil.writeJson(response, Result.build(null, ResultCodeEnum.NOTLOGIN));
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
