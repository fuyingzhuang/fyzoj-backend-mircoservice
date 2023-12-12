package com.ambition.fyzojbackendjudgeservice.judge.codesanbox.Impl;

import com.ambition.fyzojbackendjudgeservice.judge.codesanbox.CodeSandbox;
import com.ambition.fyzojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.ambition.fyzojbackendmodel.model.codesandbox.ExecuteCodeResponse;
import com.ambition.fyzojbackendmodel.model.codesandbox.JudgeInfo;
import com.ambition.fyzojbackendmodel.model.enums.JudgeInfoMessageEnum;
import com.ambition.fyzojbackendmodel.model.enums.QuestionSubmitStatusEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author Ambition
 * @date 2023/12/4 22:24
 * 代码沙箱 示例
 */
@Slf4j
//@Service
public class ExampleCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> inputList = executeCodeRequest.getInputList();
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("测试执行成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getText());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);
        executeCodeResponse.setJudgeInfo(judgeInfo);
        return executeCodeResponse;
    }
}
