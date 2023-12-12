package com.ambition.fyzojbackendqusetionservice.controller;


import com.ambition.fyzojbackendcommon.common.BaseResponse;
import com.ambition.fyzojbackendcommon.common.DeleteRequest;
import com.ambition.fyzojbackendcommon.common.ErrorCode;
import com.ambition.fyzojbackendcommon.common.ResultUtils;
import com.ambition.fyzojbackendcommon.utils.GsonUtils;
import com.ambition.fyzojbackendmodel.model.dto.question.JudgeConfig;
import com.ambition.fyzojbackendmodel.model.dto.question.QuestionAddRequest;
import com.ambition.fyzojbackendmodel.model.dto.question.QuestionEditRequest;
import com.ambition.fyzojbackendmodel.model.dto.question.QuestionQueryRequest;
import com.ambition.fyzojbackendmodel.model.entity.Question;
import com.ambition.fyzojbackendmodel.model.entity.User;
import com.ambition.fyzojbackendmodel.model.vo.QuestionVO;
import com.ambition.fyzojbackendmodel.model.vo.UserBrowseQuestionVO;
import com.ambition.fyzojbackendqusetionservice.service.QuestionService;
import com.ambition.fyzojbackendserviceclient.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * <p>
 * 题目 前端控制器
 * </p>
 *
 * @author Ambition
 * @since 2023-11-30
 */
@RestController
@RequestMapping("/oj/question")
public class QuestionController {


    @Resource
    private UserService userService;

    @Resource
    private QuestionService questionService;


    /**
     * 管理员添加题目
     *
     * @param questionAddRequest 题目添加请求
     * @return 添加结果
     */

    @PostMapping("/add")
    public BaseResponse addQuestion(@RequestBody QuestionAddRequest questionAddRequest, HttpServletRequest request) {
//        获取当前登陆的用户
        User loginUser = userService.getLoginUser(request);
//        验证用户是否是管理员
        userService.validAdmin(loginUser);
//        如果是管理员才能够执行到以下的逻辑
        // 获取当前登陆用户的id
        questionAddRequest.setUserId(loginUser.getId());
        Integer result = questionService.addQuestion(questionAddRequest);
        if (result == 1) {
            return ResultUtils.success("添加成功");
        } else {
            return ResultUtils.error(ErrorCode.SYSTEM_ERROR, "添加失败");
        }
    }


    /**
     * 管理员修改题目
     *
     * @param questionEditRequest 题目修改请求
     * @return 修改结果
     */
    @PostMapping("/edit")
    public BaseResponse editQuestion(@RequestBody QuestionEditRequest questionEditRequest, HttpServletRequest request) {
//        获取当前登陆的用户
        User loginUser = userService.getLoginUser(request);
//        验证用户是否是管理员
        userService.validAdmin(loginUser);
//        如果是管理员才能够执行到以下的逻辑
        // 获取当前登陆用户的id
        questionEditRequest.setUserId(loginUser.getId());
        Integer result = questionService.editQuestion(questionEditRequest);
        if (result == 1) {
            return ResultUtils.success("修改成功");
        } else {
            return ResultUtils.error(ErrorCode.SYSTEM_ERROR, "修改失败");
        }
    }

    /**
     * 管理员删除题目
     *
     * @param deleteRequest 删除请求
     * @param request       请求
     * @return 删除结果
     */


    @PostMapping("/delete")
    public BaseResponse deleteQuestion(@RequestBody DeleteRequest deleteRequest, HttpServletRequest request) {
        //        获取当前登陆的用户
        User loginUser = userService.getLoginUser(request);
//        验证用户是否是管理员
        userService.validAdmin(loginUser);
//        如果是管理员才能够执行到以下的逻辑
        Integer result = questionService.deleteQuestion(deleteRequest.getId());
        if (result == 1) {
            return ResultUtils.success("删除成功");
        } else {
            return ResultUtils.error(ErrorCode.SYSTEM_ERROR, "删除失败");
        }
    }

    /**
     * 查询题目
     *
     * @param questionQueryRequest 查询请求
     * @return 查询结果
     */
    @PostMapping("/list")
    public BaseResponse<Page<Question>> listByAdmin(@RequestBody QuestionQueryRequest questionQueryRequest, HttpServletRequest request) {
        //        获取当前登陆的用户
        User loginUser = userService.getLoginUser(request);
//        验证用户是否是管理员
        userService.validAdmin(loginUser);
        Page<Question> questionVOPage = questionService.listQuestion(questionQueryRequest);
        return ResultUtils.success(questionVOPage);
    }


    @GetMapping("/get/{id}")
    public BaseResponse<Question> getQuestion(@PathVariable Long id, HttpServletRequest request) {
        //        获取当前登陆的用户
        User loginUser = userService.getLoginUser(request);
        Question question = questionService.getById(id);
        return ResultUtils.success(question);
    }


    @PostMapping("/list/browse")
    public BaseResponse<Page<UserBrowseQuestionVO>> listByUser(@RequestBody QuestionQueryRequest questionQueryRequest) {
        Page<UserBrowseQuestionVO> questionVOPage = questionService.listQuestionByUser(questionQueryRequest);
        return ResultUtils.success(questionVOPage);
    }


    @GetMapping("/get/do/question/{id}")
    public BaseResponse<QuestionVO> getDoQuestionInfo(@PathVariable Long id, HttpServletRequest request) {
        //        获取当前登陆的用户
        User loginUser = userService.getLoginUser(request);
        Question question = questionService.getById(id);
        QuestionVO questionVO = new QuestionVO();
//        将question中的tags字符串转成questionVO中的tags List数组
        String[] tags = question.getTags().split(",");
        questionVO.setTags(Arrays.asList(tags));
        // 将question中的judgeConfig字符串转成JSON对象 并赋值给questionVO中的judgeConfig
        String judgeConfigStr = question.getJudgeConfig();
//        将judgeConfigStr转成JudgeConfig对象 使用Gson
        Gson gson = GsonUtils.getGson();
        questionVO.setJudgeConfig(gson.fromJson(judgeConfigStr, JudgeConfig.class));

        BeanUtils.copyProperties(question, questionVO);
        return ResultUtils.success(questionVO);
    }

}

