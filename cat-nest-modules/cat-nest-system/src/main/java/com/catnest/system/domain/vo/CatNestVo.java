package com.catnest.system.domain.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class CatNestVo implements Serializable {

    private static final long serialVersionUID = 7225264891321866091L;

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
     * 是否 锁
     */
    private Boolean lockStatus;

    /**
     * 进入密码
     */
    private String lockPassword;


}
