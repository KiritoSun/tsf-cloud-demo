package com.zt.controller;

import com.zt.request.RegisterRequest;
import com.zt.result.Result;
import com.zt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 根据姓名查询信息接口
     * @param name 姓名
     * @return json数据
     */
    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    public Result findByName(@RequestParam(value = "name") String name) {
        return userService.findByName(name);
    }

    /**
     * 注册接口
     * @param registerRequest 注册请求
     * @return json数据
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result register(@RequestBody @Valid RegisterRequest registerRequest) {
        return userService.register(registerRequest);
    }
}
