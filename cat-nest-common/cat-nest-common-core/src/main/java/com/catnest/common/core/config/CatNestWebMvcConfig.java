package com.catnest.common.core.config;


import com.catnest.common.core.interceptor.TraceIdInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;

@Slf4j
@Configuration
@ConditionalOnProperty(prefix = "cat-nest.core", name = "enable-traceId", havingValue = "true")
public class CatNestWebMvcConfig implements WebMvcConfigurer {


    @Bean
    public TraceIdInterceptor traceIdInterceptor() {
        return new TraceIdInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(traceIdInterceptor());
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    @PostConstruct
    private void postConstruct() {
        log.info("== LOAD GLOBAL TRACEID FINISH! ==");
    }
}
