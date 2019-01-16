package com.zt.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.constant.RedisConstant;
import com.zt.entity.EntityHandle;
import com.zt.entity.User;
import com.zt.enums.HandleCode;
import com.zt.exception.MyException;
import com.zt.mapper.UserMapper;
import com.zt.rabbitmq.RabbitSender;
import com.zt.request.RegisterRequest;
import com.zt.response.ValueResponse;
import com.zt.result.Result;
import com.zt.result.ResultGenerator;
import com.zt.service.UserService;
import com.zt.util.JSONUtil;
import com.zt.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserService业务实习类
 * @author zt.赵童
 * @since 2019-01-14
 */
@Service
@Transactional(rollbackFor = MyException.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private RabbitSender rabbitSender;

    @Override
    public Result<ValueResponse> findByName(String name) throws MyException {
        if (redisUtil.get(RedisConstant.REDIS_USER_STRING + name) != null) {
            User user = (User) redisUtil.get(RedisConstant.REDIS_USER_STRING + name);
            ValueResponse valueResponse = new ValueResponse(user);
            return ResultGenerator.success(valueResponse);
        } else {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("u_name", name);

            User user = null;
            user = super.getOne(queryWrapper);

            if (user == null) {
                return ResultGenerator.failure(1001, "用户不存在", null);
            } else {
                redisUtil.set(RedisConstant.REDIS_USER_STRING + name, user);

                ValueResponse valueResponse = new ValueResponse(user);
                return ResultGenerator.success(valueResponse);
            }
        }
    }

    @Override
    public Result<ValueResponse> register(RegisterRequest registerRequest) throws MyException {
        User user = registerRequest.toUser();

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_id", user.getUId());
        if (super.getOne(queryWrapper) != null) {
            return ResultGenerator.failure(1003, "该记录已存在", null);
        }


        EntityHandle entityHandle = new EntityHandle();
        entityHandle.setEntity(JSONUtil.beanToString(user));
        entityHandle.setHandleCode(HandleCode.SAVE);

        rabbitSender.sendUser(entityHandle);

        ValueResponse valueResponse = new ValueResponse(user);
        return ResultGenerator.success(valueResponse);

    }


}
