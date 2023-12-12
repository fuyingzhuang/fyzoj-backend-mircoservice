package com.ambition.fyzojbackendserviceclient.service;

import com.ambition.fyzojbackendmodel.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.ambition.fyzojbackendmodel.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 题目提交 服务类
 * </p>
 *
 * @author Ambition
 * @since 2023-11-30
 */
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    Integer addQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest);

}
