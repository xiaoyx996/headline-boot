package com.phil.headline.config;

import com.phil.headline.interceptor.HeadlineInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author Admin
 * @version 1.0
 * @description
 * TODO:web容器配置类，需要配置：
 *      1.handlerMapper、handlerAdapter、Json转换器：@EnableWebMvc
 *      2.开启默认处理器，支持静态资源
 *      3.开启controller、全局异常处理注解扫描
 * @create 2023/12/11 17:19
 */

@Configuration
public class WebJavaConfig implements WebMvcConfigurer {
    /**
     * 配置拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HeadlineInterceptor()).addPathPatterns("/headline/*");
    }
}
