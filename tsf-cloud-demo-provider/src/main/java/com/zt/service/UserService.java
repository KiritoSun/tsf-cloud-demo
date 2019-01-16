package com.zt.service;

import com.zt.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zt.exception.MyException;
import com.zt.request.RegisterRequest;
import com.zt.response.ValueResponse;
import com.zt.result.Result;

/**
 * UserService业务
 * @author zt.赵童
 * @since 2019-01-14
 */
public interface UserService extends IService<User> {

    /**
     * 根据姓名查询记录
     * @param name 姓名
     * @return Result<User>
     * @throws MyException 异常
     */
    Result<ValueResponse> findByName(String name) throws MyException;

    /**
     * 注册业务
     * @param registerRequest 注册请求
     * @return Result<User>
     * @throws MyException 异常
     */
    Result<ValueResponse> register(RegisterRequest registerRequest) throws MyException;
}
