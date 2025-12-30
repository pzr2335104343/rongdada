package com.rong.rongdadabackendappservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.rong.rongdadabackendserviceclient.service")
@MapperScan("com.rong.rongdadabackendappservice.mapper")
public class RongdadaBackendAppServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RongdadaBackendAppServiceApplication.class, args);
    }
    
}
