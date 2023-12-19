package com.phil;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ClassName: ${NAME}
 * Description:
 *
 * @Author Phil_Jackson
 * @Create ${DATE} ${TIME}
 * @Version 1.0
 */

@SpringBootApplication(scanBasePackages = {"com.phil.headline.controller", "com.phil.headline.config", "com.phil.headline.exceptionhandler",
                                            "com.phil.headline.service", "com.phil.headline.service.impl"})
@MapperScan("com.phil.headline.mapper")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}