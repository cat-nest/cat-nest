package com.catnest.common.core.interceptor;

import com.catnest.common.core.constant.StrConstant;
import io.gitee.gemini.utis.SeqUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class TraceIdInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String traceId = request.getHeader(StrConstant.TRACE_ID);
        if (!StringUtils.hasText(traceId)) {
            traceId = SeqUtil.uuid();
        }
        MDC.put(StrConstant.TRACE_ID, traceId);
        return true;
    }

}
