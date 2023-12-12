package com.ambition.fyzojbackendmodel.model.dto.question;

import lombok.Data;

/**
 * @author Ambition
 * @date 2023/11/30 23:19
 * @desc 题目配置
 */
@Data
public class JudgeConfig {

    /**
     * 时间限制（ms）
     */
    private Long timeLimit;

    /**
     * 内存限制（KB）
     */
    private Long memoryLimit;

    /**
     * 堆栈限制（KB）
     */
    private Long stackLimit;
}

