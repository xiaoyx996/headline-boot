package com.phil.headline.service.impl;
import com.phil.headline.mapper.NewsTypeMapper;
import com.phil.headline.pojo.NewsType;
import com.phil.headline.service.NewsTypeService;
import com.phil.headline.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Admin
 * @version 1.0
 * @description TODO
 * @create 2023/11/23 16:54
 */

@Service
public class NewsTypeServiceImpl implements NewsTypeService {
    @Autowired
    private NewsTypeMapper newsTypeMapper;

    @Override
    public List<NewsType> findAllTypes() {
        List<NewsType> newsTypes = newsTypeMapper.selectAll();
        return newsTypes;
    }
}
