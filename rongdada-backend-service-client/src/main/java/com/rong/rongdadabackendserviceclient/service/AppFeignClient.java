package com.rong.rongdadabackendserviceclient.service;


import com.rong.rongdadabackendmodel.entity.App;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 应用服务（内部）
 */
@FeignClient(name = "rongdada-backend-app-service", path = "/api/app/inner")
public interface AppFeignClient {

    /**
     * 根据应用id获取应用
     *
     * @param appId
     * @return app
     */
    @GetMapping("/get/id")
    App getById(@RequestParam("appId") Long appId);
}
