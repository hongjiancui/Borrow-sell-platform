package com.neusoft.bsp.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.neusoft.bsp.user.mapper")
@EnableFeignClients
public class UserMain {
    public static void main(String[] args) {
        SpringApplication.run(UserMain.class, args);
    }
}
