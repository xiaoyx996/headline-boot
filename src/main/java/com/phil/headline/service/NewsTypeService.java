package com.phil.headline.service;

import com.phil.headline.pojo.NewsType;

import java.util.List;

/**
 * @author Admin
 * @version 1.0
 * @description TODO
 * @create 2023/11/23 16:53
 */
public interface NewsTypeService {
    List<NewsType> findAllTypes();
}
