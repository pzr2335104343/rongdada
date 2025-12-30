package com.rong.rongdadabackenduseranswerservice.scoring;

import cn.hutool.json.JSONUtil;
import com.rong.rongdadabackendmodel.dto.question.QuestionContentDTO;
import com.rong.rongdadabackendmodel.entity.App;
import com.rong.rongdadabackendmodel.entity.Question;
import com.rong.rongdadabackendmodel.entity.ScoringResult;
import com.rong.rongdadabackendmodel.entity.UserAnswer;
import com.rong.rongdadabackendmodel.vo.QuestionVO;
import com.rong.rongdadabackendserviceclient.service.QuestionFeignClient;
import com.rong.rongdadabackendserviceclient.service.ScoringResultFeignClient;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * 自定义打分类应用评分策略
 */
@ScoringStrategyConfig(appType = 0, scoringStrategy = 0)
public class CustomScoreScoringStrategy implements ScoringStrategy {

    @Resource
    private QuestionFeignClient questionFeignClient;

    @Resource
    private ScoringResultFeignClient scoringResultFeignClient;

    @Override
    public UserAnswer doScore(List<String> choices, App app) throws Exception {
        Long appId = app.getId();
        // 1. 根据 id 查询到题目和题目结果信息（按分数降序排序）
        Question question = questionFeignClient.getOne(appId);
        List<ScoringResult> scoringResultList = scoringResultFeignClient.list(appId);

        // 2. 统计用户的总得分
        int totalScore = 0;
        QuestionVO questionVO = QuestionVO.objToVo(question);
        List<QuestionContentDTO> questionContent = questionVO.getQuestionContent();
        // 答案索引
        int index = 0;
        // 遍历题目列表
        for (QuestionContentDTO questionContentDTO : questionContent) {
            // 遍历题目中的选项
            for (QuestionContentDTO.Option option : questionContentDTO.getOptions()) {
                // 如果答案和选项的key匹配
                if (option.getKey().equals(choices.get(index))) {
                    int score = Optional.of(option.getScore()).orElse(0);
                    totalScore += score;
                }
            }
            index++;
        }

        // 3. 遍历得分结果，找到第一个用户分数大于得分范围的结果，作为最终结果
        ScoringResult maxScoringResult = scoringResultList.get(0);
        for (ScoringResult scoringResult : scoringResultList) {
            if (totalScore >= scoringResult.getResultScoreRange()) {
                maxScoringResult = scoringResult;
                break;
            }
        }

        // 4. 构造返回值，填充答案对象的属性
        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setAppId(appId);
        userAnswer.setAppType(app.getAppType());
        userAnswer.setScoringStrategy(app.getScoringStrategy());
        userAnswer.setChoices(JSONUtil.toJsonStr(choices));
        userAnswer.setResultId(maxScoringResult.getId());
        userAnswer.setResultName(maxScoringResult.getResultName());
        userAnswer.setResultDesc(maxScoringResult.getResultDesc());
        userAnswer.setResultPicture(maxScoringResult.getResultPicture());
        userAnswer.setResultScore(totalScore);
        return userAnswer;
    }
}
