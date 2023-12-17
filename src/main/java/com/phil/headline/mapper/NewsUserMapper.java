package com.phil.headline.mapper;



import com.phil.headline.pojo.NewsUser;

/**
 * @author Admin
 * @version 1.0
 * @description TODO
 * @create 2023/11/23 11:12
 */
public interface NewsUserMapper {

    NewsUser selectByUsername(String username);

    NewsUser selectByUserId(int uid);

    int addUser(NewsUser registUser)throws Exception;
}
