package com.ambition.fyzojbackendmodel.model.dto.question;

import lombok.Data;

/**
 * @author Ambition
 * @date 2023/11/30 23:19
 * @desc 题目判题用例
 */
@Data
public class JudgeCase {

    /**
     * 输入用例
     */
    private String input;

    /**
     * 输出用例
     */
    private String output;
}
