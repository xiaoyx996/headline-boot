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

@SpringBootApplication
@MapperScan("com.phil.headline.mapper")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}