package com.klfront.klblog.uaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 用户登录与授权服务（User Account and Authentication）
 *
 * @author:lujinlong
 **/
@SpringBootApplication
//@EnableHystrix
public class UAAServer {
    public static void main(String[] args) {
        SpringApplication.run(UAAServer.class, args);
    }
}
