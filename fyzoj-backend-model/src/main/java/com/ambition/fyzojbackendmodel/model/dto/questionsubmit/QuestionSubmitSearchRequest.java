package com.ambition.fyzojbackendmodel.model.dto.questionsubmit;

import com.ambition.fyzojbackendcommon.common.PageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Ambition
 * @date 2023/12/1 16:05
 * @desc 提交题目编辑请求
 */
@Data
public class QuestionSubmitSearchRequest  extends PageRequest implements Serializable {
    private static final long serialVersionUID = 1L;


    private String language;

    private String code;

    private String judgeInfo;

    private Integer status;

    private Long questionId;

    private Long userId;


}
