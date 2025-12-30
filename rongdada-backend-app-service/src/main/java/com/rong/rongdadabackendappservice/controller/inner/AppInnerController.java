package com.rong.rongdadabackendappservice.controller.inner;

import com.rong.rongdadabackendappservice.service.AppService;
import com.rong.rongdadabackendmodel.entity.App;
import com.rong.rongdadabackendserviceclient.service.AppFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/inner")
public class AppInnerController implements AppFeignClient {

    @Resource
    private AppService appService;

    /**
     * 根据应用id获取应用
     *
     * @param appId
     * @return app
     */
    @GetMapping("/get/id")
    public App getById(Long appId){
        return appService.getById(appId);
    }
}
