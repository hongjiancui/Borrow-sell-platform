package com.neusoft.bsp.oauth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer //对外开启暴露获取token的API接口
@EnableDiscoveryClient
@MapperScan("com.neusoft.bsp.oauth.mapper")
@EnableFeignClients
public class OAuthMain {
    public static void main(String[] args) {
        SpringApplication.run(OAuthMain.class, args);
    }
}
