package com.zt.rabbitmq;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zt.constant.QueueConstant;
import com.zt.entity.EntityHandle;
import com.zt.entity.User;
import com.zt.mapper.UserMapper;
import com.zt.util.JSONUtil;
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

    /**
     * 消息消费者 --
     * @param msg 接受消息
     */
    @RabbitListener(queues = QueueConstant.USER_QUEUE_NAME)
    public void receiverUser(String msg) {
        EntityHandle entityHandle = JSONUtil.stringToBean(msg, EntityHandle.class);

        User user = JSONUtil.stringToBean(entityHandle.getEntity(), User.class);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_id", user.getUId());

        switch (entityHandle.getHandleCode()) {
            case SAVE: {
                userMapper.insert(user);
                break;
            }
            case DEL: {
                userMapper.delete(queryWrapper);
                break;
            }
            case UPDATE: {
                userMapper.update(user, queryWrapper);
                break;
            }
            case NO: {
                break;
            }
            default:
        }
    }
}
