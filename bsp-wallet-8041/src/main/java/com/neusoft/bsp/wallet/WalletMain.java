package com.neusoft.bsp.wallet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.neusoft.bsp.wallet.mapper")
@EnableFeignClients
public class WalletMain {
    public static void main(String[] args) {
        SpringApplication.run(WalletMain.class, args);
    }
}
