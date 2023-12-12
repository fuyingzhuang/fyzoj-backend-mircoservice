package com.ambition.fyzojbackendmodel.model.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Ambition
 * @date 2023/12/4 00:00
 * 用户浏览题目VO
 */
@Data
public class UserBrowseQuestionVO {
    /**
     * id
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 标签列表
     */
    private List<String> tags;

    /**
     * 题目提交数
     */
    private Integer submitNum;

    /**
     * 题目通过数
     */
    private Integer acceptedNum;


    /**
     * 创建时间
     */
    private Date createTime;


}
