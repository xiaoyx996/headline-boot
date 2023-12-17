package com.phil.headline.mapper;

import com.phil.headline.pojo.NewsHeadline;
import com.phil.headline.pojo.vo.HeadlineDetailVo;
import com.phil.headline.pojo.vo.HeadlinePageVo;
import com.phil.headline.pojo.vo.HeadlineQueryVo;

import java.util.List;

/**
 * @author Admin
 * @version 1.0
 * @description TODO
 * @create 2023/11/24 10:46
 */
public interface NewsHeadlineMapper {
    List<HeadlinePageVo> findNewsPage(HeadlineQueryVo headlineQueryVo);

    Integer findNewsNum(HeadlineQueryVo headlineQueryVo);

    HeadlineDetailVo showHeadlineDetail(Integer hid);

    void increasePageViews(Integer hid);

    int addHeadline(NewsHeadline newsHeadline);

    NewsHeadline findHeadlineByHid(Integer hid);

    int update(NewsHeadline newsHeadline);

    int removeByHid(Integer hid);
}
