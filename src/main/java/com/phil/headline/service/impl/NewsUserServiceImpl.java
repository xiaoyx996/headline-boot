package com.phil.headline.service.impl;

import com.phil.headline.mapper.NewsUserMapper;
import com.phil.headline.pojo.NewsUser;
import com.phil.headline.service.NewsUserService;
import com.phil.headline.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Admin
 * @version 1.0
 * @description TODO
 * @create 2023/11/23 11:22
 */
@Service
public class NewsUserServiceImpl implements NewsUserService {

    @Autowired
    private NewsUserMapper newsUserMapper;

    @Override
    public NewsUser selectByUsername(String username) {
        NewsUser newsUser = newsUserMapper.selectByUsername(username);
        return newsUser;
    }

    @Override
    public NewsUser selectByUserId(int uid) {
        NewsUser newsUser = newsUserMapper.selectByUserId(uid);
        return newsUser;
    }

    @Override
    public int addUser(NewsUser registUser) {
        int count = 0;
        try {
            count = newsUserMapper.addUser(registUser);
            // 提交事务
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            return count;
        }
    }
}
