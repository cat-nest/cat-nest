package com.catnest.common.core.domain.out;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Primary;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ApiRequest<T> implements Serializable {
    private static final long serialVersionUID = -6923170272670809963L;
    //真实请求内容
    private T data;
    //时间戳
    private String timestamp;
}
