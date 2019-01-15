package com.zt.rabbitmq;

import com.zt.constant.QueueConstant;
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

    /**
     *传递user对象的队列
     */
    @Bean
    public Queue userQueue() {
        return new Queue(QueueConstant.USER_QUEUE_NAME);
    }

}
