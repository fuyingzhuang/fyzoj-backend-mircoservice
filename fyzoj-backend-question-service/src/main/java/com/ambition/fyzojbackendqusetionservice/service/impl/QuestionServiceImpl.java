package com.ambition.fyzojbackendqusetionservice.service.impl;

import com.ambition.fyzojbackendmodel.model.dto.question.*;
import com.ambition.fyzojbackendmodel.model.entity.Question;
import com.ambition.fyzojbackendmodel.model.vo.UserBrowseQuestionVO;
import com.ambition.fyzojbackendqusetionservice.mapper.QuestionMapper;
import com.ambition.fyzojbackendqusetionservice.service.QuestionService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 题目 服务实现类
 * </p>
 *
 * @author Ambition
 * @since 2023-11-30
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {

    //    定义一个静态的Gson对象
    private static final Gson gson = new Gson();

    /**
     * 添加题目
     *
     * @param questionAddRequest 题目添加请求
     * @return 添加结果
     */
    @Override
    public Integer addQuestion(QuestionAddRequest questionAddRequest) {
        Question question = new Question();
//        将questionAddRequest的属性拷贝到question中
        BeanUtils.copyProperties(questionAddRequest, question);
        List<JudgeCase> judgeCase = questionAddRequest.getJudgeCase();
//        将judgeCase转换为json字符串 用于存储到数据库中
        String judgeCaseStr = gson.toJson(judgeCase);
        question.setJudgeCase(judgeCaseStr);
        JudgeConfig judgeConfig = questionAddRequest.getJudgeConfig();
//        将judgeConfig转换为json字符串 用于存储到数据库中
        String judgeConfigStr = gson.toJson(judgeConfig);
        question.setJudgeConfig(judgeConfigStr);
//        将tags转换为json字符串 用于存储到数据库中
        String tagsStr = gson.toJson(questionAddRequest.getTags());
        question.setTags(tagsStr);
//        将question插入到数据库中
        return baseMapper.insert(question);
    }

    /**
     * 编辑题目
     *
     * @param questionEditRequest 题目编辑请求
     * @return 编辑结果
     */

    @Override
    public Integer editQuestion(QuestionEditRequest questionEditRequest) {
        Question question = new Question();
//        将questionEditRequest的属性拷贝到question中
        BeanUtils.copyProperties(questionEditRequest, question);
        List<JudgeCase> judgeCase = questionEditRequest.getJudgeCase();
//        将judgeCase转换为json字符串 用于存储到数据库中
        String judgeCaseStr = gson.toJson(judgeCase);
        question.setJudgeCase(judgeCaseStr);
        JudgeConfig judgeConfig = questionEditRequest.getJudgeConfig();
//        将judgeConfig转换为json字符串 用于存储到数据库中
        String judgeConfigStr = gson.toJson(judgeConfig);
        question.setJudgeConfig(judgeConfigStr);
//        将question更新到数据库中

        return baseMapper.updateById(question);
    }

    /**
     * 删除题目
     *
     * @param id 题目id
     * @return 删除结果
     */
    @Override
    public Integer deleteQuestion(Long id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public Page<Question> listQuestion(QuestionQueryRequest questionQueryRequest) {
//        构建一个查询条件
        QueryWrapper<Question> questionQueryWrapper = new QueryWrapper<>();
//        如果题目标题不为空 则添加题目标题的查询条件
        String title = questionQueryRequest.getTitle();
        if (title != null && !title.isEmpty()) {
            questionQueryWrapper.like("title", title);
        }
//        如果内容不为空 则添加内容的查询条件
        String content = questionQueryRequest.getContent();
        if (content != null && !content.isEmpty()) {
            questionQueryWrapper.eq("content", content);
        }
        List<String> tags = questionQueryRequest.getTags();
//        判断标签是否为空
        if (tags != null && !tags.isEmpty()) {
            // 如果标签不为空，则添加标签的OR查询条件
            questionQueryWrapper.and(wrapper -> {
                for (int i = 0; i < tags.size(); i++) {
                    String tag = tags.get(i);
                    if (i == 0) {
                        wrapper.like("tags", tag);
                    } else {
                        wrapper.or().like("tags", tag);
                    }
                }
            });
        }
//        获取当前的页数和每页的大小
        long current = questionQueryRequest.getCurrent();
        long pageSize = questionQueryRequest.getSize();
//        使用list查询
        Page<Question> questionPage = baseMapper.selectPage(new Page<>(current, pageSize), questionQueryWrapper);
//        for (Question record : questionPage.getRecords()) {
////          将answerCount设置为null 过滤掉answer
//            record.setAnswer(null);
//        }
        return questionPage;
    }

    @Override
    public Page<UserBrowseQuestionVO> listQuestionByUser(QuestionQueryRequest questionQueryRequest) {
//        构建一个查询条件
        QueryWrapper<Question> questionQueryWrapper = new QueryWrapper<>();
//        如果题目标题不为空 则添加题目标题的查询条件
        String title = questionQueryRequest.getTitle();
        if (title != null && !title.isEmpty()) {
            questionQueryWrapper.like("title", title);
        }
//        如果内容不为空 则添加内容的查询条件
        String content = questionQueryRequest.getContent();
        if (content != null && !content.isEmpty()) {
            questionQueryWrapper.eq("content", content);
        }
        List<String> tags = questionQueryRequest.getTags();
//        判断标签是否为空
        if (tags != null && !tags.isEmpty()) {
            // 如果标签不为空，则添加标签的OR查询条件
            questionQueryWrapper.and(wrapper -> {
                for (int i = 0; i < tags.size(); i++) {
                    String tag = tags.get(i);
                    if (i == 0) {
                        wrapper.like("tags", tag);
                    } else {
                        wrapper.or().like("tags", tag);
                    }
                }
            });
        }
//        获取当前的页数和每页的大小
        long current = questionQueryRequest.getCurrent();
        long pageSize = questionQueryRequest.getSize();
//        使用list查询
        Page<Question> questionPage = baseMapper.selectPage(new Page<>(current, pageSize), questionQueryWrapper);
        Page<UserBrowseQuestionVO> userBrowseQuestionVOPage = new Page<>();
        BeanUtils.copyProperties(questionPage, userBrowseQuestionVOPage);
        List<UserBrowseQuestionVO> userBrowseQuestionVOS = new ArrayList<>();
        for (Question question : questionPage.getRecords()) {
            UserBrowseQuestionVO userBrowseQuestionVO = new UserBrowseQuestionVO();
            BeanUtils.copyProperties(question, userBrowseQuestionVO);
//            将tags转换为list
            List<String> tagsList = gson.fromJson(question.getTags(), new TypeToken<List<String>>() {
            }.getType());
            userBrowseQuestionVO.setTags(tagsList);
            userBrowseQuestionVOS.add(userBrowseQuestionVO);
        }
        userBrowseQuestionVOPage.setRecords(userBrowseQuestionVOS);
        return userBrowseQuestionVOPage;
    }


}
