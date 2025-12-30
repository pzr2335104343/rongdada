package com.rong.rongdadabackenduserservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.rong.rongdadabackenduserservice.mapper")
public class RongdadaBackendUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RongdadaBackendUserServiceApplication.class, args);
    }

}
