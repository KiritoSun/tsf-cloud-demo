package com.zt.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.entity.User;
import com.zt.exception.BizException;
import com.zt.mapper.UserMapper;
import com.zt.request.RegisterRequest;
import com.zt.result.Result;
import com.zt.result.ResultGenerator;
import com.zt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = BizException.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Result<User> findByName(String name) throws BizException {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_name", name);

        User user = null;
        user = super.getOne(queryWrapper);

        if (user == null) {
            return ResultGenerator.failure(1001, "用户不存在", null);
        } else {
            return ResultGenerator.success(user);
        }
    }

    @Override
    public Result<User> register(RegisterRequest registerRequest) throws BizException {
        User user = registerRequest.toUser();

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_id", user.getUId());
        if (super.getOne(queryWrapper) != null) {
            return ResultGenerator.failure(1003, "该记录已存在", null);
        }

        boolean result = super.save(user);
        if (!result) {
            return ResultGenerator.failure(1002, "注册失败", null);
        } else {
            return ResultGenerator.success(user);
        }
    }


}
