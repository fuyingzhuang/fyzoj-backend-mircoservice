package com.ambition.fyzojbackendmodel.model.entity;

import lombok.Data;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.*;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * <p>
 * 题目提交
 * </p>
 *
 * @author Ambition
 * @since 2023-11-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class QuestionSubmit implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    private String language;

    private String code;

    @TableField("judgeInfo")
    private String judgeInfo;

    private Integer status;

    @TableField("questionId")
    private Long questionId;

    @TableField("userId")
    private Long userId;

    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "updateTime", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField("isDelete")
    @TableLogic
    private Integer isDelete;


}
