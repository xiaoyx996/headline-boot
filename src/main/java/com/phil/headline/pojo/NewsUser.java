package com.phil.headline.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Admin
 * @version 1.0
 * @description TODO
 * @create 2023/11/22 18:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsUser implements Serializable {
    private Integer uid;
    private String username;
    private String userPwd;
    private String nickName;
}
