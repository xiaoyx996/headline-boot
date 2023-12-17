package com.phil.headline.mapper;

import com.phil.headline.pojo.NewsType;

import java.util.List;

/**
 * @author Admin
 * @version 1.0
 * @description TODO
 * @create 2023/11/23 16:42
 */
public interface NewsTypeMapper {
    List<NewsType> selectAll();
}
