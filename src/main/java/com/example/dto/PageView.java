package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * PageView
 *
 * @author yezw1506
 * @date 2019-02-28
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageView<T> {

    /**
     * 当前页
     */
    private Integer pageNum;

    /**
     * 每页的数量
     */
    private Integer pageSize;

    /**
     * 总页面
     */
    private Integer pages;

    /**
     * 总记录数
     */
    private Long total;

    /**
     * 结果集
     */
    private List<T> list;
}
