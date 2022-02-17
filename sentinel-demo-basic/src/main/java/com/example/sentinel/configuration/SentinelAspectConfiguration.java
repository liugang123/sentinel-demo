package com.example.sentinel.configuration;


import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import org.springframework.context.annotation.Configuration;

/**
 * sentinel支持注解配置
 *
 * @author liugang
 * @create 2022/2/17
 */
@Configuration
public class SentinelAspectConfiguration {

    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }
}
