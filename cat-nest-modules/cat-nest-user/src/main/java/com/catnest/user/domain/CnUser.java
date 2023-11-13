package com.catnest.user.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName cn_user
 */
@Data
public class CnUser implements Serializable {
    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    private String username;

    /**
     * 
     */
    private String userPassword;

    /**
     * 
     */
    private Integer userSts;

    /**
     * 
     */
    private Date registerDt;

    private static final long serialVersionUID = 1L;
}