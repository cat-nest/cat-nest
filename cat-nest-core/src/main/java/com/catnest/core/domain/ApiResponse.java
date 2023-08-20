package com.catnest.core.domain;

import com.catnest.core.constant.BaseConstant;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ApiResponse<T> implements Serializable {
    private static final long serialVersionUID = -7219223537667379552L;

    public int code;

    public boolean success;

    public String message;

    public T data;


    public static ApiResponse doFail(String message) {
        return new ApiResponse<>(BaseConstant.FAIL, false, message, null);
    }

    public static ApiResponse doFail(int code, String message) {
        return new ApiResponse<>(code, false, message, null);
    }

    public static <T> ApiResponse<T> doSuccess(T data) {
        return new ApiResponse<>(BaseConstant.SUCCESS, true, "请求成功", data);
    }

    public static <T> ApiResponse<T> doSuccess(String message, T data) {
        return new ApiResponse<>(BaseConstant.SUCCESS, true, message, data);
    }

    public static <T> ApiResponse<T> doSuccess(int code, String message, T data) {
        return new ApiResponse<>(code, true, message, data);
    }

}
