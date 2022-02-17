package com.example.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 实例控制器
 *
 * @author liugang
 * @create 2022/2/17
 */
@RestController
@RequestMapping("/rest/demo/")
public class RestDemoController {

    @RequestMapping("/test")
    @SentinelResource("test")
    public String test() {
        return "method test:" + new Date();
    }

    @RequestMapping("/method")
    public String method() {
        return "method";
    }

    @RequestMapping("/circuitBreak")
    public String circuitBreak() {
        return "ciruitBreak";
    }
}
