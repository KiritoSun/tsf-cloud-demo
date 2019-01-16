package com.zt.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 封装返回值格式
 * @author zt.赵童
 * @since 2019-01-16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValueResponse {
    /**
     * 返回的值
     */
    private Object result;
}
