package com.rong.rongdadabackenduseranswerservice.controller.inner;

import com.rong.rongdadabackendmodel.dto.statistic.AppAnswerCountDTO;
import com.rong.rongdadabackendmodel.dto.statistic.AppAnswerResultCountDTO;
import com.rong.rongdadabackendserviceclient.service.UserAnswerFeignClient;
import com.rong.rongdadabackenduseranswerservice.mapper.UserAnswerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户答案接口 
 */
@RestController
@RequestMapping("/inner")
@Slf4j
public class UserAnswerInnerController implements UserAnswerFeignClient {

    @Resource
    private UserAnswerMapper userAnswerMapper;

    /**
     * 热门应用及回答数统计（top 10）
     *
     * @return
     */
    @Override
    public List<AppAnswerCountDTO> getAppAnswerCount() {
        return userAnswerMapper.getAppAnswerCount();
    }

    /**
     * 单应用回答结果分布统计
     *
     * @param appId
     * @return
     */
    @Override
    public List<AppAnswerResultCountDTO> getAppAnswerResultCount(Long appId) {
        return userAnswerMapper.getAppAnswerResultCount(appId);
    }
}
