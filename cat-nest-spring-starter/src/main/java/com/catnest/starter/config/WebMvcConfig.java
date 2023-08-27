package com.catnest.starter.config;


import com.catnest.starter.interceptor.TranceInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;

@Slf4j
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TranceInterceptor());
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    @PostConstruct
    private void postConstruct() {
        log.info("== load global traceid finish! ==");
    }
}
