package com.zt.rabbit;

import com.zt.enums.CONSTANT;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消息队列定义
 * @author zt.赵童
 * @since 2019-01-14
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue stringQueue() {
        return new Queue(CONSTANT.STRING_QUEUE_NAME);
    }

    @Bean
    public Queue userQueue() {
        return new Queue(CONSTANT.USER_QUEUE_NAME);
    }

}
