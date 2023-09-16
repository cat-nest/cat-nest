package com.catnest.common.core.domain.out;

import com.catnest.common.core.constant.BaseConstant;
import com.catnest.common.core.domain.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutApiResponse<T> implements Serializable {
    private static final long serialVersionUID = -7219223537667379552L;

    private int retCode;

    private boolean retStatus;

    private String retMessage;

    private T data;


    public static <T> OutApiResponse<T> doFail(String message) {
        return new OutApiResponse<>(BaseConstant.FAIL, false, message, null);
    }

    public static <T> OutApiResponse<T> doFail(int code, String message) {
        return new OutApiResponse<>(code, false, message, null);
    }

    public static <T> OutApiResponse<T> doSuccess(T data) {
        return new OutApiResponse<>(BaseConstant.SUCCESS, true, "请求成功", data);
    }

    public static <T> OutApiResponse<T> doSuccess(String message, T data) {
        return new OutApiResponse<>(BaseConstant.SUCCESS, true, message, data);
    }

    public static <T> OutApiResponse<T> doSuccess(int code, String message, T data) {
        return new OutApiResponse<>(code, true, message, data);
    }

}
