package com.ambition.fyzojbackendjudgeservice.judge.codesanbox;


import com.ambition.fyzojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.ambition.fyzojbackendmodel.model.codesandbox.ExecuteCodeResponse;

/**
 * @author Ambition
 * @date 2023/12/4 22:16
 * 代码沙箱 接口
 */
public interface CodeSandbox {

    /**
     * 执行代码
     *
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);

}
