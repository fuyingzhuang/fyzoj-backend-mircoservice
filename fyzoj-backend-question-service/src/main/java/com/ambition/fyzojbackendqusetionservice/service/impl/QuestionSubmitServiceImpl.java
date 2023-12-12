package com.ambition.fyzojbackendqusetionservice.service.impl;

import com.ambition.fyzojbackendmodel.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.ambition.fyzojbackendmodel.model.entity.QuestionSubmit;
import com.ambition.fyzojbackendqusetionservice.mapper.QuestionSubmitMapper;
import com.ambition.fyzojbackendqusetionservice.service.QuestionService;
import com.ambition.fyzojbackendqusetionservice.service.QuestionSubmitService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 题目提交 服务实现类
 * </p>
 *
 * @author Ambition
 * @since 2023-11-30
 */
@Service
public class QuestionSubmitServiceImpl extends ServiceImpl<QuestionSubmitMapper, QuestionSubmit> implements QuestionSubmitService {


    @Resource
    private QuestionService questionService;


    @Override
    public Integer addQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest) {
//        QuestionSubmit questionSubmit = new QuestionSubmit();
//        BeanUtils.copyProperties(questionSubmitAddRequest, questionSubmit);
//        CodeSandbox codeSandbox = CodeSandBoxFactory.createThirdPartyCodeSandbox("remote");
//        codeSandbox = new CodeSandBoxProxy(codeSandbox);
//        String code = questionSubmitAddRequest.getCode();
//        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
////        根据题目id获取题目信息
//        Long questionId = questionSubmitAddRequest.getQuestionId();
//        Question questionInfo = questionService.getById(questionId);
//        String judgeCaseStr = questionInfo.getJudgeCase();
//        // 将judgeCase转换成List<JudgeCase>
//        // [{"input":"123","output":"21new Gson();
//        Gson gson = GsonUtils.getGson();
//        List<JudgeCase> judgeCaseList = gson.fromJson(judgeCaseStr, new TypeToken<List<JudgeCase>>() {
//        }.getType());
//        String inputStr = "";
//        String outputStr = "";
//        for (JudgeCase jc : judgeCaseList) {
//            inputStr += jc.getInput() + " ";
//            outputStr += jc.getOutput() + " ";
//        }
//
////        List<String> inputList = Arrays.asList("1 2", "3 4");
//        List<String> inputList = Arrays.asList(inputStr, outputStr);
//        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
//                .code(code)
//                .language(language)
//                .inputList(inputList)
//                .build();
//        // 将 executeCode 包装在 CompletableFuture 中
//
//        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
//        String json = GsonUtils.getGson().toJson(executeCodeResponse);
//        questionSubmit.setJudgeInfo(json);
//        return baseMapper.insert(questionSubmit);
        return 0;
    }


}
