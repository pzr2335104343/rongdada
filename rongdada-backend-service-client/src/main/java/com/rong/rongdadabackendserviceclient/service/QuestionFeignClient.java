package com.rong.rongdadabackendserviceclient.service;


import com.rong.rongdadabackendmodel.entity.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 题目服务（内部）
 */
@FeignClient(name = "rongdada-backend-question-service", path = "/api/question/inner")
public interface QuestionFeignClient {

    /**
     * 根据应用ID获取问题实体
     *
     * @param appId 应用ID
     * @return 问题实体
     */
    @GetMapping("/get/one")
    Question getOne(@RequestParam("appId") Long appId);

}
