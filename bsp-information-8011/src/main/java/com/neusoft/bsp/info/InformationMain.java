package com.neusoft.bsp.info;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.neusoft.bsp.info.mapper")
public class InformationMain {
    public static void main(String[] args) {
        SpringApplication.run(InformationMain.class, args);
    }
}
