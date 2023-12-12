package com.ambition.fyzojbackendjudgeservice.judge.codesanbox.Impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.ambition.fyzojbackendcommon.common.ErrorCode;
import com.ambition.fyzojbackendcommon.exception.BusinessException;
import com.ambition.fyzojbackendjudgeservice.judge.codesanbox.CodeSandbox;
import com.ambition.fyzojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.ambition.fyzojbackendmodel.model.codesandbox.ExecuteCodeResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author Ambition
 * @date 2023/12/4 22:25
 * 远程代码沙箱
 */
@Service
public class RemoteCodeSandbox implements CodeSandbox {

    // 定义鉴权请求头和密钥
    private static final String AUTH_REQUEST_HEADER = "auth";

    private static final String AUTH_REQUEST_SECRET = "secretKey";


    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("远程代码沙箱");
        String url = "http://localhost:8000/code/sandbox/executeCode";
        String json = JSONUtil.toJsonStr(executeCodeRequest);
        String responseStr = HttpUtil.createPost(url)
                .header(AUTH_REQUEST_HEADER, AUTH_REQUEST_SECRET)
                .body(json)
                .execute()
                .body();
        if (StringUtils.isBlank(responseStr)) {
            throw new BusinessException(ErrorCode.API_REQUEST_ERROR, "executeCode remoteSandbox error, message = " + responseStr);
        }
        return JSONUtil.toBean(responseStr, ExecuteCodeResponse.class);
    }
}
