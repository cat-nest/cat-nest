package com.catnest.starter.config;


import com.catnest.starter.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@Slf4j
public class CatNestAutoConfig {

    @Bean
    public SpringContextUtil springContextUtil() {
        return new SpringContextUtil();
    }


    @PostConstruct
    private void postConstruct() {
        log.info("== load cat-nest-spring-stater finish! ==");
    }

}
