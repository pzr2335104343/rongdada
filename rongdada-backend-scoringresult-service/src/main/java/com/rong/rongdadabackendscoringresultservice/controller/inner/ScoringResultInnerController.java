package com.rong.rongdadabackendscoringresultservice.controller.inner;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rong.rongdadabackendmodel.entity.ScoringResult;
import com.rong.rongdadabackendscoringresultservice.service.ScoringResultService;
import com.rong.rongdadabackendserviceclient.service.ScoringResultFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评分结果接口
 */
@RestController
@RequestMapping("/inner")
@Slf4j
public class ScoringResultInnerController implements ScoringResultFeignClient {

    @Resource
    private ScoringResultService scoringResultService;

    /**
     * 根据应用ID获取评分结果列表
     *
     * @param appId 应用ID
     * @return 评分结果列表
     */
    @Override
    @GetMapping("/list")
    public List<ScoringResult> list(@RequestParam("appId") Long appId) {
        LambdaQueryWrapper<ScoringResult> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ScoringResult::getAppId, appId);
        // 按分数降序排序
        wrapper.orderByDesc(ScoringResult::getResultScoreRange);
        return scoringResultService.list(wrapper);
    }
}