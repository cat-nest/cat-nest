package com.catnest.common.validate.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Slf4j
@Configuration
@ComponentScan(basePackages = "com.catnest.common.validate")
public class ValidateConfig {
    @PostConstruct
    public void postConstruct() {
        log.info("== LOAD VALIDATE UTIL FINISH ==");
    }
}
