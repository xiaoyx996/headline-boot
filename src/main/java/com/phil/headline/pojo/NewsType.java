package com.phil.headline.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Admin
 * @version 1.0
 * @description TODO
 * @create 2023/11/23 16:30
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsType implements Serializable {
    private Integer tid;
    private String tname;
}
