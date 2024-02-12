package com.catnest.user.domain.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class LoginVO implements Serializable {
    private static final long serialVersionUID = -7401424371725720373L;

    @NotNull
    private String userName;

    @NotNull
    private String password;

}
