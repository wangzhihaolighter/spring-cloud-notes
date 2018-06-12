package com.example.springframework.cloud.eureka.consumer.feign.upload.server.web.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("demo-eureka-client")
public interface DemoEurekaClient {

    @RequestMapping("/")
    String home();

}