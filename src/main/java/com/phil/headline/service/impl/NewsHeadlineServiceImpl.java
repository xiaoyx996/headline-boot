package com.phil.headline.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.phil.headline.mapper.NewsHeadlineMapper;
import com.phil.headline.pojo.NewsHeadline;
import com.phil.headline.pojo.vo.HeadlineDetailVo;
import com.phil.headline.pojo.vo.HeadlinePageVo;
import com.phil.headline.pojo.vo.HeadlineQueryVo;
import com.phil.headline.service.NewsHeadlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Admin
 * @version 1.0
 * @description TODO
 * @create 2023/11/23 16:54
 */

@Service
public class NewsHeadlineServiceImpl implements NewsHeadlineService {

    @Autowired
    private NewsHeadlineMapper newsHeadlineMapper;

    /**
     *        "totalPage":20, // 总页数
     *        "totalSize":200 // 总记录数
     *        "pageData":[// 本页的数据
     *             {
     *     				"hid":"1",                     // 新闻id
     *     				"title":"尚硅谷宣布 ... ...",   // 新闻标题
     *     				"type":"1",                    // 新闻所属类别编号
     *     				"pageViews":"40",              // 新闻浏览量
     *     				"pastHours":"3" ,              // 发布时间已过小时数
     *     				"publisher":"1"                // 发布用户ID
     * 				},
     *     		],
     * 			"pageNum":1,    //页码数
     * 			"pageSize":10,  // 页大小
     *
     * @param headlineQueryVo
     * @return
     */
    @Override
    public Map<String, Object> findNewsPage(HeadlineQueryVo headlineQueryVo) {
        // 分页查询：借助分页插件
        PageHelper.startPage(headlineQueryVo.getPageNum(), headlineQueryVo.getPageSize());
        List<HeadlinePageVo> headlinePageVoList = newsHeadlineMapper.findNewsPage(headlineQueryVo);
        PageInfo<HeadlinePageVo> headlinePageVoPageInfo = new PageInfo<>(headlinePageVoList);

        // 按要求生成返回的map
        Map<String, Object> pageInfo = new HashMap<>();
        Integer pageNum = headlineQueryVo.getPageNum();
        Integer pageSize = headlineQueryVo.getPageSize();
        long totalSize = headlinePageVoPageInfo.getTotal();
        Integer totalPage = headlinePageVoPageInfo.getPages();
        pageInfo.put("pageNum", pageNum);
        pageInfo.put("pageSize", pageSize);
        pageInfo.put("totalPage", totalPage);
        pageInfo.put("totalSize", totalSize);
        pageInfo.put("pageData", headlinePageVoPageInfo.getList());
        return pageInfo;
    }

    @Override
    public HeadlineDetailVo showHeadlineDetail(Integer hid) {
        // 头条浏览量 + 1
        newsHeadlineMapper.increasePageViews(hid);
        // 查询头条详情
        HeadlineDetailVo headlineDetailVo = newsHeadlineMapper.showHeadlineDetail(hid);

        return headlineDetailVo;
    }

    @Override
    public int addNewsHeadline(NewsHeadline newsHeadline) {
        int count = newsHeadlineMapper.addHeadline(newsHeadline);
        return count;
    }

    @Override
    public NewsHeadline findHeadlineByHid(Integer hid) {
        NewsHeadline newsHeadline = newsHeadlineMapper.findHeadlineByHid(hid);
        return newsHeadline;
    }

    @Override
    public int update(NewsHeadline newsHeadline) {
        int count = newsHeadlineMapper.update(newsHeadline);
        return count;
    }

    @Override
    public int removeByHid(Integer hid) {
        int count = newsHeadlineMapper.removeByHid(hid);
        return count;
    }
}
