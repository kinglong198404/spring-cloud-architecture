package com.klfront.klblog.uaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * 用户登录与授权服务（User Account and Authentication）
 *
 * @author:lujinlong
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
//@EnableFeignClients(basePackages = {"com.klfront.klblog.uaa.uaa"})
public class UAAServer {
    public static void main(String[] args) {
        SpringApplication.run(UAAServer.class, args);
    }
}
