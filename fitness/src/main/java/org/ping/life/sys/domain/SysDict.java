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
 * 系统字典表
 *
 * @author ping
 */
@TableName(value = "sys_dict")
@Data
public class SysDict implements Serializable {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 字典类型编码
     */
    @TableField(value = "type_code")
    private String typeCode;
    /**
     * 字典项的键
     */
    @TableField(value = "dict_key")
    private String dictKey;
    /**
     * 字典项的值
     */
    @TableField(value = "dict_value")
    private String dictValue;
    /**
     * 字典项的描述
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