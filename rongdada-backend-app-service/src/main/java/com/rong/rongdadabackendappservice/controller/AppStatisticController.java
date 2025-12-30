package com.rong.rongdadabackendappservice.controller;


import com.rong.rongdadabackendcommon.common.BaseResponse;
import com.rong.rongdadabackendcommon.common.ErrorCode;
import com.rong.rongdadabackendcommon.common.ResultUtils;
import com.rong.rongdadabackendcommon.exception.ThrowUtils;
import com.rong.rongdadabackendmodel.dto.statistic.AppAnswerCountDTO;
import com.rong.rongdadabackendmodel.dto.statistic.AppAnswerResultCountDTO;
import com.rong.rongdadabackendserviceclient.service.UserAnswerFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * App统计分析接口
 */
@RestController
@RequestMapping("/statistic")
@Slf4j
public class AppStatisticController {

    @Resource
    private UserAnswerFeignClient userAnswerFeignClient;

    /**
     * 热门应用及回答数统计（top 10）
     *
     * @return
     */
    @GetMapping("/answer_count")
    public BaseResponse<List<AppAnswerCountDTO>> getAppAnswerCount() {
        return ResultUtils.success(userAnswerFeignClient.getAppAnswerCount());
    }

    /**
     * 某应用回答结果分布统计
     *
     * @param appId
     * @return
     */
    @GetMapping("/answer_result_count")
    public BaseResponse<List<AppAnswerResultCountDTO>> getAppAnswerResultCount(Long appId) {
        ThrowUtils.throwIf(appId == null || appId <= 0, ErrorCode.PARAMS_ERROR);
        return ResultUtils.success(userAnswerFeignClient.getAppAnswerResultCount(appId));
    }
}
