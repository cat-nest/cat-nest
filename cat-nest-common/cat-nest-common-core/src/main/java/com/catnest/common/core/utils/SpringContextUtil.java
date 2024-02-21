package com.catnest.common.core.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@Slf4j
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("== INIT SPRING-CONTEXT-UTIL FINISH ==");
        SpringContextUtil.applicationContext = applicationContext;
    }

    //根据类型获取bean
    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    //根据beanName获取bean
    public static <T> T getBean(String beanId, Class<T> clazz) {
        return applicationContext.getBean(beanId, clazz);
    }

}