package com.ambition.fyzojbackendjudgeservice.judge;

import com.ambition.fyzojbackendjudgeservice.judge.codesanbox.strategy.DefaultJudgeStrategy;
import com.ambition.fyzojbackendjudgeservice.judge.codesanbox.strategy.JavaLanguageJudgeStrategy;
import com.ambition.fyzojbackendjudgeservice.judge.codesanbox.strategy.JudgeContext;
import com.ambition.fyzojbackendjudgeservice.judge.codesanbox.strategy.JudgeStrategy;
import com.ambition.fyzojbackendmodel.model.codesandbox.JudgeInfo;
import com.ambition.fyzojbackendmodel.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * @author Ambition
 * @date 2023/12/5 00:06
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext 上下文
     * @return 判题结果
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}
