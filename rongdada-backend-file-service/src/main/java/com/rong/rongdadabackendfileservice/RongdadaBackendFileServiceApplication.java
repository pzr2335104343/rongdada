package com.rong.rongdadabackendfileservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.rong.rongdadabackendserviceclient.service")
public class RongdadaBackendFileServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RongdadaBackendFileServiceApplication.class, args);
    }

}
