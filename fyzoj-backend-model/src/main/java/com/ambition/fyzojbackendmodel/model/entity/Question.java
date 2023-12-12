package com.ambition.fyzojbackendmodel.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 题目
 * </p>
 *
 * @author Ambition
 * @since 2023-11-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    private String title;

    private String content;

    private String tags;

    private String answer;

    @TableField("submitNum")
    private Integer submitNum;

    @TableField("acceptedNum")
    private Integer acceptedNum;

    @TableField("judgeCase")
    private String judgeCase;

    @TableField("judgeConfig")
    private String judgeConfig;

    @TableField("thumbNum")
    private Integer thumbNum;

    @TableField("favourNum")
    private Integer favourNum;

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
