package org.ping.life.fitness.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 锻炼记录表
 *
 * @author Ping
 */
@TableName(value = "exercise_record")
@Data
public class ExerciseRecord implements Serializable {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID（外键，关联用户表）
     */
    @TableField(value = "user_id")
    private String userId;
    /**
     *
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 锻炼动作ID（外键，关联锻炼动作表）
     */
    @TableField(value = "action_id")
    private String actionId;

    /**
     * 锻炼持续时间（以分钟为单位）
     */
    @TableField(value = "duration")
    private Integer duration;

    /**
     * 完成的组数
     */
    @TableField(value = "sets")
    private Integer sets;

    /**
     * 每组的重复次数
     */
    @TableField(value = "repetitions")
    private Integer repetitions;

    /**
     * 使用的重量（如果适用）
     */
    @TableField(value = "weight")
    private BigDecimal weight;

    /**
     * 额外的备注信息
     */
    @TableField(value = "notes")
    private String notes;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    /**
     * 锻炼日期
     */
    @TableField(value = "time")
    private Date time;
}