package com.ambition.fyzojbackendjudgeservice.judge.codesanbox;


import com.ambition.fyzojbackendjudgeservice.judge.codesanbox.Impl.ExampleCodeSandbox;
import com.ambition.fyzojbackendjudgeservice.judge.codesanbox.Impl.RemoteCodeSandbox;
import com.ambition.fyzojbackendjudgeservice.judge.codesanbox.Impl.ThirdPartyCodeSandbox;

/**
 * @author Ambition
 * @date 2023/12/4 22:39
 * 代码沙箱工厂 静态工厂 用于创建代码沙箱
 */
public  class CodeSandBoxFactory {

    /**
     * 创建第三方代码沙箱
     *
     * @return 代码沙箱
     */
    public static CodeSandbox createThirdPartyCodeSandbox(String type) {
        switch (type) {
            case "example":
                return new ExampleCodeSandbox();

            case "remote":
                return new RemoteCodeSandbox();

            case "thirdParty":
                return new ThirdPartyCodeSandbox();

            default:
                return new ExampleCodeSandbox();
        }


    }
}
