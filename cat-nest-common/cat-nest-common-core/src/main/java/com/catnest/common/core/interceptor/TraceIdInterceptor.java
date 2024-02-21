package com.catnest.common.core.interceptor;

import com.catnest.common.core.constant.StrConstant;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class TraceIdInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String traceId = request.getHeader(StrConstant.TRACE_ID);
        MDC.put(StrConstant.TRACE_ID, traceId);
        return true;
    }

}
