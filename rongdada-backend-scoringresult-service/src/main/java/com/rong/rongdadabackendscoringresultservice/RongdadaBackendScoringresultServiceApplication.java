package com.rong.rongdadabackendscoringresultservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.rong.rongdadabackendserviceclient.service")
@MapperScan("com.rong.rongdadabackendscoringresultservice.mapper")
public class RongdadaBackendScoringresultServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RongdadaBackendScoringresultServiceApplication.class, args);
    }

}
