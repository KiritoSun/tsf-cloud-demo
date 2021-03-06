package com.zt.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 封装分页格式
 * @author zt.赵童
 * @since 2019-01-16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResponse {
    /**
     * 当前所处页数
     */
    private Integer current;

    /**
     * 每页有多少元素
     */
    private Integer size;

    /**
     * 总共有多少元素
     */
    private Integer total;

    /**
     * 一共有多少页
     */
    private Integer pages;

    /**
     * 是否成功查询
     */
    private Boolean searchCount = true;

    /**
     * 分页的记录
     */
    private Object records;
}
