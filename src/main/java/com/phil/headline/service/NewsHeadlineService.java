package com.phil.headline.service;

import com.phil.headline.pojo.NewsHeadline;
import com.phil.headline.pojo.vo.HeadlineDetailVo;
import com.phil.headline.pojo.vo.HeadlineQueryVo;

import java.util.Map;

/**
 * @author Admin
 * @version 1.0
 * @description TODO
 * @create 2023/11/23 16:53
 */
public interface NewsHeadlineService {
    Map<String, Object> findNewsPage(HeadlineQueryVo headlineQueryVo);

    HeadlineDetailVo showHeadlineDetail(Integer hid);

    int addNewsHeadline(NewsHeadline newsHeadline);

    NewsHeadline findHeadlineByHid(Integer hid);

    int update(NewsHeadline newsHeadline);

    int removeByHid(Integer hid);
}
