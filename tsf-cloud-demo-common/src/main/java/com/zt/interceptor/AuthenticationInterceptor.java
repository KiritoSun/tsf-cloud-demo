package com.zt.interceptor;

import com.zt.annotation.NoToken;
import com.zt.annotation.Token;
import com.zt.exception.AuthException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 权限拦截器操作
 * @author zt.赵童
 * @since 2019-01-16
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse
            , Object object) throws Exception {
        String token = httpServletRequest.getHeader("token");
        // @desc : 如果不是映射到方法直接通过
        if(!(object instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method=handlerMethod.getMethod();
        // @desc : 检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(NoToken.class)) {
            NoToken passToken = method.getAnnotation(NoToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        // @desc : 检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(Token.class)) {
            Token userLoginToken = method.getAnnotation(Token.class);
            if (userLoginToken.required()) {
                // @desc : 执行认证
                if (token == null) {
                    throw new AuthException();
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
