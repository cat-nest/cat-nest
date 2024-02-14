package com.catnest.common.validate.advice;


import com.catnest.common.core.domain.ApiResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@RestControllerAdvice
public class ValidateControllerAdvice {
    /**
     * 校验异常
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ApiResponse<Object> exceptionHandler(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder errorMesssage = new StringBuilder();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMesssage.append(fieldError.getDefaultMessage());
        }
        return ApiResponse.doFail(errorMesssage.toString());
    }

    /**
     * 校验异常
     */
    @ExceptionHandler(value = BindException.class)
    public ApiResponse<Object> validationExceptionHandler(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder errorMesssage = new StringBuilder();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMesssage.append(fieldError.getDefaultMessage());
        }
        return ApiResponse.doFail(errorMesssage.toString());
    }

    /**
     * 校验异常
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ApiResponse<Object> ConstraintViolationExceptionHandler(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
        List<String> msgList = new ArrayList<>();
        while (iterator.hasNext()) {
            ConstraintViolation<?> cvl = iterator.next();
            msgList.add(cvl.getMessageTemplate());
        }
        return ApiResponse.doFail(String.join(",", msgList));
    }

}
