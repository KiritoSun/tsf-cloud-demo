package com.zt.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValueResponse {
    /**
     * 返回的值
     */
    private Object result;
}
