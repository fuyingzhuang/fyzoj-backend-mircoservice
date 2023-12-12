package com.ambition.fyzojbackendmodel.model.dto.questionsubmit;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 题目提交
 * </p>
 *
 * @author Ambition
 * @since 2023-11-30
 */
@Data
public class QuestionSubmitAddRequest implements Serializable {

    private static final long serialVersionUID = 1L;


    private String language;

    private String code;

    private String judgeInfo;

    private Integer status;

    private Long questionId;

    private Long userId;


}
