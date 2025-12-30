package com.rong.rongdadabackendquestionbackend.controller.inner;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rong.rongdadabackendmodel.entity.Question;
import com.rong.rongdadabackendquestionbackend.service.QuestionService;
import com.rong.rongdadabackendserviceclient.service.QuestionFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 题目接口
 */
@RestController
@RequestMapping("/inner")
@Slf4j
public class QuestionInnerController implements QuestionFeignClient {

    @Resource
    private QuestionService questionService;


    /**
     * 根据应用ID获取问题实体
     *
     * @param appId 应用ID
     * @return 问题实体
     */
    @Override
    @GetMapping("/get/one")
    public Question getOne(@RequestParam("appId") Long appId) {
        LambdaQueryWrapper<Question> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Question::getAppId, appId);
        return questionService.getOne(wrapper);
    }
}