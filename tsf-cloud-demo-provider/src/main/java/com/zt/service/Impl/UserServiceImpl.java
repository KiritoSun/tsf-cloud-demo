package com.zt.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.entity.User;
import com.zt.exception.BizException;
import com.zt.mapper.UserMapper;
import com.zt.rabbit.RabbitSender;
import com.zt.request.RegisterRequest;
import com.zt.response.ValueResponse;
import com.zt.result.Result;
import com.zt.result.ResultGenerator;
import com.zt.service.UserService;
import com.zt.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = BizException.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private RabbitSender rabbitSender;

    @Override
    public Result<ValueResponse> findByName(String name) throws BizException {
        if (redisUtil.get("user_name_" + name) != null) {
            User user = (User) redisUtil.get("user_name_" + name);
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
                redisUtil.set("user_name_" + name, user);

                ValueResponse valueResponse = new ValueResponse(user);
                return ResultGenerator.success(valueResponse);
            }
        }
    }

    @Override
    public Result<ValueResponse> register(RegisterRequest registerRequest) throws BizException {
        User user = registerRequest.toUser();

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_id", user.getUId());
        if (super.getOne(queryWrapper) != null) {
            return ResultGenerator.failure(1003, "该记录已存在", null);
        }

        rabbitSender.sendUser(user);
        ValueResponse valueResponse = new ValueResponse(user);
        return ResultGenerator.success(valueResponse);
    }


}
