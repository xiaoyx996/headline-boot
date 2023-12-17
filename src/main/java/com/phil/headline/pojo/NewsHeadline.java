package com.phil.headline.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author Admin
 * @version 1.0
 * @description TODO
 * @create 2023/11/23 16:32
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewsHeadline implements Serializable {
    /**
     * 头条ID
     */
    private Integer hid;

    /**
     * 头条标题
     */
    private String title;

    /**
     * 头条文章内容
     */
    private String article;

    /**
     * 所属类别ID
     */
    private Integer type;
    private NewsType newsType;

    /**
     * 发布者ID
     */
    private Integer publisher;
    private NewsUser newsUser;

    /**
     * 浏览量
     */
    private Integer pageViews;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否被删除，1：被删除，0：未被删除
     */
    private Integer isDeleted;
}
