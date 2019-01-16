package com.zt.filter;

import com.netflix.zuul.ZuulFilter;

public class MyGatewayFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;   //优先级为0，数字越大，优先级越低
    }

    @Override
    public boolean shouldFilter() {
        return true; // 是否执行该过滤器，此处为true，说明需要过滤
    }

    @Override
    public Object run() {
        return null;
    }
}
