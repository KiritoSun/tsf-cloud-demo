package com.zt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.tsf.route.annotation.EnableTsfRoute;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.tsf.auth.annotation.EnableTsfAuth;
import org.springframework.tsf.ratelimit.annotation.EnableTsfRateLimit;

/**
 * @author zt.zhao
 * @since 2019-1-14
 */
@SpringBootApplication
@EnableDiscoveryClient          // 使用服务注册发现时请启用
@EnableFeignClients             // 使用Feign微服务调用时请启用
@EnableConfigurationProperties  // 使用分布式配置时请启用
@EnableAutoConfiguration
@EnableTsfAuth
@EnableTsfRoute
@EnableTsfRateLimit
@EnableTransactionManagement
@MapperScan("com.zt.mapper")
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}
