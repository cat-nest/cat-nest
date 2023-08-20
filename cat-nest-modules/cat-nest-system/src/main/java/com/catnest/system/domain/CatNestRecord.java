package com.catnest.system.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName cat_nest_record
 */
@Data
public class CatNestRecord implements Serializable {
    /**
     * 
     */
    private Integer nestId;

    /**
     * 猫窝名字
     */
    private String nestName;

    /**
     * 猫窝描述
     */
    private String nestDesc;

    /**
     * 猫窝类型 0聊天 1文件 03聊天+文件
     */
    private String nestType;

    /**
     * 猫窝状态 默认0
     */
    private Integer nestSts;

    /**
     * 创建人
     */
    private Integer createUseId;

    /**
     * 创建时间
     */
    private Date createDt;

    /**
     * 更新时间
     */
    private Date updateDt;

    private static final long serialVersionUID = 1L;
}