package com.zt.rabbit;

import com.zt.entity.User;
import com.zt.enums.CONSTANT;
import com.zt.mapper.UserMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息队列消费
 * @author zt.赵童
 * @since 2019-01-14
 */
@Component
public class RabbitReceiver {
    @Autowired
    private UserMapper userMapper;

    @RabbitListener(queues = CONSTANT.USER_QUEUE_NAME)
    public void saveUser(User user) {
        userMapper.insert(user);
    }
}
