package com.catnest.starter.aspect;


import com.catnest.common.core.utils.CollectionUtil;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import javax.annotation.PostConstruct;
import java.util.Map;


@Aspect
@Slf4j
public class ParamLogAspect {

    @Pointcut("@annotation(com.catnest.starter.annontation.ParamLog)")
    public void pointCut() {
    }


    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        String[] parameterNames = signature.getParameterNames();
        Object[] args = proceedingJoinPoint.getArgs();
        String name = signature.getName();
        Map<String, Object> params = CollectionUtil.mergeCollection(parameterNames, args);
        log.info("===method:{} ==入参:{}", name, params);

        return proceedingJoinPoint.proceed();
    }

    @PostConstruct
    public void postConstruct() {
        log.info("== 参数打印切片加载成功 ==");
    }

}
