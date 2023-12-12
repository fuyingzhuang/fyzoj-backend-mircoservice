package com.ambition.fyzojbackendqusetionservice.controller;


import com.ambition.fyzojbackendcommon.common.BaseResponse;
import com.ambition.fyzojbackendcommon.common.ErrorCode;
import com.ambition.fyzojbackendcommon.common.ResultUtils;
import com.ambition.fyzojbackendmodel.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.ambition.fyzojbackendmodel.model.dto.questionsubmit.QuestionSubmitSearchRequest;
import com.ambition.fyzojbackendmodel.model.entity.QuestionSubmit;
import com.ambition.fyzojbackendmodel.model.entity.User;
import com.ambition.fyzojbackendqusetionservice.service.QuestionSubmitService;
import com.ambition.fyzojbackendserviceclient.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 题目提交 前端控制器
 * </p>
 *
 * @author Ambition
 * @since 2023-11-30
 */
@RestController
@RequestMapping("/oj/question/submit")
public class QuestionSubmitController {


    @Resource
    private QuestionSubmitService questionSubmitService;


    @Resource
    private UserService userService;


    /**
     * 用户提交题目
     *
     * @param questionSubmitAddRequest 提交题目的请求
     * @param request                  请求
     * @return 提交结果
     */
    @PostMapping("/submit")
    public BaseResponse addQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
                                          HttpServletRequest request) {
//      判断当前用户是否登陆
        User loginUser = userService.getLoginUser(request);
//        获取当前的用户id
        Long id = loginUser.getId();
        questionSubmitAddRequest.setUserId(id);
        // 获取题目的id
        Long questionId = questionSubmitAddRequest.getQuestionId();
//        调用service层的方法
        Integer result = questionSubmitService.addQuestionSubmit(questionSubmitAddRequest);
        if (result == 0) {
            return ResultUtils.error(ErrorCode.SYSTEM_ERROR, "提交失败");
        } else {
            return ResultUtils.success("提交成功");
        }
    }


    @PostMapping("/list")
    public BaseResponse listQuestionSubmit(@RequestBody QuestionSubmitSearchRequest questionSubmitSearchRequest,
                                           HttpServletRequest request) {
//      判断当前用户是否登陆
        User loginUser = userService.getLoginUser(request);
        QueryWrapper<QuestionSubmit> questionSubmitQueryWrapper = new QueryWrapper<>();
//        获取当前用户提交的语言
//        String language = questionSubmitSearchRequest.getLanguage();
//        if (language != null || !"".equals(language)) {
//            questionSubmitQueryWrapper.eq("language", language);
//        }
//        // 获取题目的id 可以根据题目查询
//
//        Long questionId = questionSubmitSearchRequest.getQuestionId();
//        if (questionId != null || questionId != 0) {
//            questionSubmitQueryWrapper.eq("questionId", questionId);
//        }
//        // 获取用户的id
//        Long userId = questionSubmitSearchRequest.getUserId();
//        if (userId != null || userId != 0) {
//            questionSubmitQueryWrapper.eq("userId", userId);
//        }
//        分页查询
        long size = questionSubmitSearchRequest.getSize();
        long current = questionSubmitSearchRequest.getCurrent();
        Page<QuestionSubmit> page = questionSubmitService.page(new Page<>(current, size), questionSubmitQueryWrapper);
        return ResultUtils.success(page);
//

    }

}

