package org.ping.life.fitness.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 锻炼动作表
 *
 * @author ping
 * @TableName exercise_action
 */
@TableName(value = "exercise_action")
@Data
public class ExerciseAction implements Serializable {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 动作名称
     */
    @TableField(value = "name")
    private String name;
    /**
     * 动作分类（如力量、心肺、柔韧性）
     */
    @TableField(value = "category")
    private String category;
    /**
     * 目标肌肉群（如胸部、腿部、背部）
     */
    @TableField(value = "target_muscles")
    private String targetMuscles;
    /**
     * 难度级别（1：初级，2：中级，3：高级）
     */
    @TableField(value = "difficulty")
    private Integer difficulty;
    /**
     * 所需器材（如哑铃、杠铃、自重）
     */
    @TableField(value = "equipment")
    private String equipment;
    /**
     * 动作描述
     */
    @TableField(value = "description")
    private String description;
    /**
     * 教学视频链接（可选）
     */
    @TableField(value = "video_url")
    private String videoUrl;
    /**
     * 状态（1：启用，0：禁用）
     */
    @TableField(value = "status")
    private Integer status;
    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;
}