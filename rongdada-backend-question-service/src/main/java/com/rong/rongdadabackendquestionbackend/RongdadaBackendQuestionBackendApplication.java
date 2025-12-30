package com.rong.rongdadabackendquestionbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.rong.rongdadabackendserviceclient.service")
@MapperScan("com.rong.rongdadabackendquestionbackend.mapper")
public class RongdadaBackendQuestionBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(RongdadaBackendQuestionBackendApplication.class, args);
    }

}
