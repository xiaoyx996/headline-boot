package com.phil.headline.controller;

import jakarta.servlet.annotation.WebServlet;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Admin
 * @version 1.0
 * @description TODO
 * @create 2023/11/23 17:20
 */
@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("type")
public class NewsTypeController{
}
