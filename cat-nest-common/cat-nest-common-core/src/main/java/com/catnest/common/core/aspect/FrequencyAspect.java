package com.catnest.common.core.aspect;

import com.catnest.common.core.annontation.FrequencyCtrl;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 频率控制切面
 * todo 待完善
 */
@Aspect
@Slf4j
public class FrequencyAspect {


    @Pointcut("@annotation(frequencyCtrl)")
    public void Pointcut(FrequencyCtrl frequencyCtrl) {
    }

    @Around(value = "Pointcut(frequencyCtrl)", argNames = "pjp,frequencyCtrl")
    public Object around(ProceedingJoinPoint pjp, FrequencyCtrl frequencyCtrl) throws Throwable {
        //限制时间
        long period = frequencyCtrl.period();
        //访问次数
        long count = frequencyCtrl.count();
        return pjp.proceed();
    }
}
