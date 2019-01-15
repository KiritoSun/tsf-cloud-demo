package com.zt.rabbitmq;

import com.zt.constant.QueueConstant;
import com.zt.entity.EntityHandle;
import com.zt.entity.User;
import com.zt.util.JSONUtil;
import com.zt.util.StringUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息队列发送者
 * @author zt.赵童
 * @since 2019-01-14
 */
@Component
public class RabbitSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送user实体的消息
     * @param entityHandle user实体对应操作
     */
    public void sendUser(EntityHandle entityHandle) {
        String msg = JSONUtil.beanToString(entityHandle);
        amqpTemplate.convertAndSend(QueueConstant.USER_QUEUE_NAME, msg);
    }
}
