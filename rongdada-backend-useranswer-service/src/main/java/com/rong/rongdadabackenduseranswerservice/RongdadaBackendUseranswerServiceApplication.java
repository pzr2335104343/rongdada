package com.rong.rongdadabackenduseranswerservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.rong.rongdadabackendserviceclient.service")
@MapperScan("com.rong.rongdadabackenduseranswerservice.mapper")

public class RongdadaBackendUseranswerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RongdadaBackendUseranswerServiceApplication.class, args);
    }

}
