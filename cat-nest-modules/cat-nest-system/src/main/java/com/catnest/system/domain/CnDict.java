package com.catnest.system.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统字典表
 *
 * @TableName cn_dict
 */
@Data
public class CnDict implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 字典key
     */
    private String dicKey;

    /**
     * 字典内容
     */
    private String dicDesc;

    /**
     * 启用状态
     */
    private Boolean enable;

    /**
     * 创建时间
     */
    private Date createDt;

    /**
     * 创建人
     */
    private String createUser;

    private static final long serialVersionUID = 1L;
}