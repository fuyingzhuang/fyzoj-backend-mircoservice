package com.ambition.fyzojbackendqusetionservice.service;

import com.ambition.fyzojbackendmodel.model.dto.question.QuestionAddRequest;
import com.ambition.fyzojbackendmodel.model.dto.question.QuestionEditRequest;
import com.ambition.fyzojbackendmodel.model.dto.question.QuestionQueryRequest;
import com.ambition.fyzojbackendmodel.model.entity.Question;
import com.ambition.fyzojbackendmodel.model.vo.UserBrowseQuestionVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 题目 服务类
 * </p>
 *
 * @author Ambition
 * @since 2023-11-30
 */
public interface QuestionService extends IService<Question> {

    Integer addQuestion(QuestionAddRequest questionAddRequest);

    Integer editQuestion(QuestionEditRequest questionEditRequest);

    Integer deleteQuestion(Long id);

    Page<Question> listQuestion(QuestionQueryRequest questionQueryRequest);

    Page<UserBrowseQuestionVO> listQuestionByUser(QuestionQueryRequest questionQueryRequest);
}
