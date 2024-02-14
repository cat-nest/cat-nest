package com.catnest.starter.aspect;


import com.catnest.common.core.utils.CollectionUtil;
import com.catnest.starter.annontation.ParamLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import javax.annotation.PostConstruct;
import java.util.Map;


@Aspect
@Slf4j
public class ParamLogAspect {


    @Around("@annotation(paramLog)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint, ParamLog paramLog) throws Throwable {

        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        String name = signature.getName();
        boolean enableLogRetVal = false;
        String methodDesc = "";

        if (paramLog != null) {
            enableLogRetVal = paramLog.enableLogRetVal();
            methodDesc = paramLog.methodDesc();
        }
        try {
            String[] parameterNames = signature.getParameterNames();
            Object[] args = proceedingJoinPoint.getArgs();

            Map<String, Object> params = CollectionUtil.mergeCollection(parameterNames, args);

            log.info("=== Method:{} === Note:{} === Param:{}", name, methodDesc, params);
        } catch (Exception e) {
            log.warn("方法入参打印失败,一场捕获，流程继续", e);
        }

        Object proceed = proceedingJoinPoint.proceed();

        if (enableLogRetVal) {
            log.info("=== Method:{} === Note:{} === Result:{}", name, methodDesc, proceed);
        }

        return proceed;
    }

    @PostConstruct
    public void postConstruct() {
        log.info("== LOAN PARAMLOG FINISH ==");
    }

}
