package com.rong.rongdadabackendserviceclient.service;


import com.rong.rongdadabackendmodel.entity.ScoringResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 评分结果服务（内部）
 */
@FeignClient(name = "rongdada-backend-scoringresult-service", path = "/api/scoringResult/inner")
public interface ScoringResultFeignClient {

    /**
     * 根据应用ID获取评分结果列表
     *
     * @param appId 应用ID
     * @return 评分结果列表
     */
    @GetMapping("/list")
    List<ScoringResult> list(@RequestParam("appId") Long appId);
}
