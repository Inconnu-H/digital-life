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
 * 系统字典分类表
 *
 * @author ping
 * @TableName sys_dict_type
 */
@TableName(value = "sys_dict_type")
@Data
public class SysDictType implements Serializable {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 字典类型编码，唯一
     */
    @TableField(value = "type_code")
    private String typeCode;
    /**
     * 字典类型名称
     */
    @TableField(value = "type_name")
    private String typeName;
    /**
     * 字典类型描述
     */
    @TableField(value = "description")
    private String description;
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