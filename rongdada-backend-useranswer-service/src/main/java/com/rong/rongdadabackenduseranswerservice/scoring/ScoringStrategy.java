package com.rong.rongdadabackenduseranswerservice.scoring;


import com.rong.rongdadabackendmodel.entity.App;
import com.rong.rongdadabackendmodel.entity.UserAnswer;

import java.util.List;

/**
 * 评分策略
 */
public interface ScoringStrategy {

    /**
     * 执行评分
     * @param choice
     * @param app
     * @return
     * @throws Exception
     */
    UserAnswer doScore(List<String> choice, App app) throws  Exception;
}
