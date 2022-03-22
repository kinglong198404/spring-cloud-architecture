package com.klfront.klblog.dataconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages= {"com.klfront.klblog"})
public class DataConsumerApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(DataConsumerApplication.class, args);
	}

}
