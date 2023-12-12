package com.ambition.fyzojbackendjudgeservice.judge.codesanbox.strategy;

import com.ambition.fyzojbackendmodel.model.codesandbox.JudgeInfo;
import com.ambition.fyzojbackendmodel.model.dto.question.JudgeCase;
import com.ambition.fyzojbackendmodel.model.entity.Question;
import com.ambition.fyzojbackendmodel.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * @author Ambition
 * @date 2023/12/4 23:51
 * 上下文（用于定义在策略中传递的参数）
 */
@Data
public class JudgeContext {
    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private List<JudgeCase> judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;


}
