package com.zt.entity;

import com.zt.enums.HandleCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 封装消息队列传递的对象
 * @author zt.赵童
 * @since 2019-01-16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntityHandle {
    /**
     * json化的数据库实体
     */
    private String entity;

    /**
     * 对该实体在数据库进行的操作
     */
    private HandleCode handleCode;
}
