package com.phil.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: TestController
 * Description:
 *
 * @Author Phil_Jackson
 * @Create 2023/12/15 20:59
 * @Version 1.0
 */
@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping
    public String test(){
        return "Test!!!!";
    }
}
