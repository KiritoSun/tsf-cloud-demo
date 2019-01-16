package com.zt.remote;

import com.zt.enums.ResultCode;
import com.zt.request.RegisterRequest;
import com.zt.result.Result;
import com.zt.result.ResultGenerator;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 *
 */
@FeignClient(name = "tsf-cloud-demo-provider", fallback = UserRemoteService.DefaultFallback.class)
public interface UserRemoteService {

    @RequestMapping(value = "/user/findByName", method = RequestMethod.GET)
    Result findByName(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    Result register(@RequestBody @Valid RegisterRequest registerRequest);

    /**
     * 容错处理类
     */
    @Component
    class DefaultFallback implements UserRemoteService {

        @Override
        public Result findByName(String name) {
            return ResultGenerator.failure(ResultCode.SYSTEM_INNER_ERROR);
        }

        @Override
        public Result register(RegisterRequest registerRequest) {
            return ResultGenerator.failure(ResultCode.SYSTEM_INNER_ERROR);
        }
    }
}
