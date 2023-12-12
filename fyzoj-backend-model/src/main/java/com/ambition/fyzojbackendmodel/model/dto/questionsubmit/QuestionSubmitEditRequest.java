package com.ambition.fyzojbackendmodel.model.dto.questionsubmit;

import lombok.Data;

/**
 * @author Ambition
 * @date 2023/12/1 16:05
 * @desc 提交题目编辑请求
 */
@Data
public class QuestionSubmitEditRequest {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String language;

    private String code;

    private String judgeInfo;

    private Integer status;

    private Long questionId;

    private Long userId;


}
