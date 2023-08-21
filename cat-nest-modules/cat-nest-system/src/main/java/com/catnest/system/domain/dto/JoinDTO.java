package com.catnest.system.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class JoinDTO implements Serializable {

    private static final long serialVersionUID = 2140907056810373725L;

    private Long nestId;

    private String lockPassword;

}
