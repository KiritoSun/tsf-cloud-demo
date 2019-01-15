package com.zt.entity;

import com.zt.enums.HandleCode;
import com.zt.util.JSONUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 封装消息队列传递的对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntityHandle {
    private String entity;
    private HandleCode handleCode;
}
