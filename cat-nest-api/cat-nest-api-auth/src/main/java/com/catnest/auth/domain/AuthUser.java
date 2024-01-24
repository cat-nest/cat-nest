package com.catnest.auth.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AuthUser implements Serializable {
    private static final long serialVersionUID = -8287740774117844891L;

    private String userId;

    private String userName;

    private List<String> roles;

}
