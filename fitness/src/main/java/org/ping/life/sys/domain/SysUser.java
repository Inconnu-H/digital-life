package org.ping.life.sys.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 *
 * @author Ping
 * @TableName sys_user
 */
@TableName(value = "sys_user")
@Data
public class SysUser implements Serializable {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户名，唯一
     */
    @TableField(value = "username")
    private String username;
    /**
     * 密码（加密存储）
     */
    @TableField(value = "password")
    private String password;
    /**
     * 用户邮箱，唯一
     */
    @TableField(value = "email")
    private String email;
    /**
     * 用户全名
     */
    @TableField(value = "full_name")
    private String fullName;
    /**
     * 用户昵称
     */
    @TableField(value = "nick_name")
    private String nickName;
    /**
     * 用户电话号码（可选）
     */
    @TableField(value = "phone")
    private String phone;
    /**
     * 出生日期（可选）
     */
    @TableField(value = "birthdate")
    private Date birthdate;
    /**
     * 性别（可选）
     */
    @TableField(value = "gender")
    private Object gender;
    /**
     * 状态（1：激活，0：禁用）
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