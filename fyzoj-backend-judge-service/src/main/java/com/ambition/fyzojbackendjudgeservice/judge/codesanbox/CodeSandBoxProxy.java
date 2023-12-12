package com.ambition.fyzojbackendjudgeservice.judge.codesanbox;

import com.ambition.fyzojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.ambition.fyzojbackendmodel.model.codesandbox.ExecuteCodeResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Ambition
 * @date 2023/12/4 22:57
 * 使用代理模式 增强代码沙箱 例如：记录日志
 */
@Slf4j
public class CodeSandBoxProxy implements CodeSandbox {

    private CodeSandbox codeSandbox;

    public CodeSandBoxProxy(CodeSandbox codeSandbox) {
        this.codeSandbox = codeSandbox;
    }

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        log.info("代码沙箱请求信息:{}", executeCodeRequest);
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        log.info("代码沙箱响应信息:{}", executeCodeResponse);
        return executeCodeResponse;
    }
}
