package com.ambition.fyzojbackendjudgeservice.judge.codesanbox.Impl;

import com.ambition.fyzojbackendjudgeservice.judge.codesanbox.CodeSandbox;
import com.ambition.fyzojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.ambition.fyzojbackendmodel.model.codesandbox.ExecuteCodeResponse;
import org.springframework.stereotype.Service;

/**
 * @author Ambition
 * @date 2023/12/4 22:26
 * 第三方代码沙箱 调用第三方接口
 */
@Service
public class ThirdPartyCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("第三方代码沙箱");
        return null;
    }
}

