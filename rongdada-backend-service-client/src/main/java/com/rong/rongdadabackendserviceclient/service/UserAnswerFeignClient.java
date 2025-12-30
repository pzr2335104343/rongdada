package com.rong.rongdadabackendserviceclient.service;


import com.rong.rongdadabackendmodel.dto.statistic.AppAnswerCountDTO;
import com.rong.rongdadabackendmodel.dto.statistic.AppAnswerResultCountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 用户回答服务（内部）
 */
@FeignClient(name = "rongdada-backend-useranswer-service", path = "/api/userAnswer/inner")
public interface UserAnswerFeignClient {


    /**
     * 热门应用及回答数统计（top 10）
     *
     * @return
     */
    @GetMapping("get/answer/count")
    public List<AppAnswerCountDTO> getAppAnswerCount();

    /**
     * 单应用回答结果分布统计
     *
     * @param appId
     * @return
     */
    @GetMapping("get/answer/result/count")
    public List<AppAnswerResultCountDTO> getAppAnswerResultCount(@RequestParam("appId") Long appId);
}
