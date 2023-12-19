package com.phil.headline.service;

import com.phil.headline.pojo.NewsUser;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLIntegrityConstraintViolationException;


/**
 * @author Admin
 * @version 1.0
 * @description TODO
 * @create 2023/11/23 11:22
 */
public interface NewsUserService {

    NewsUser selectByUsername(String username);

    NewsUser selectByUserId(int uid);

    int addUser(NewsUser registUser);
}
