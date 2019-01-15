package com.zt.rabbit;

import com.zt.entity.User;
import com.zt.enums.CONSTANT;
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

    public boolean sendString(String info) {
        if (StringUtils.isEmpty(info)) {
            return false;
        } else {
            amqpTemplate.convertAndSend(CONSTANT.STRING_QUEUE_NAME, info);
            return true;
        }
    }

    public boolean sendUser(User user) {
        if (user == null) {
            return false;
        } else {
            amqpTemplate.convertAndSend(CONSTANT.USER_QUEUE_NAME, user);
            return true;
        }
    }
}
