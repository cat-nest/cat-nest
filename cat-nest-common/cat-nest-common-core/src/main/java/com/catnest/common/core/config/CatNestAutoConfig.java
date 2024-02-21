package com.catnest.common.core.config;


import com.catnest.common.core.aspect.FrequencyAspect;
import com.catnest.common.core.aspect.ParamLogAspect;
import com.catnest.common.core.utils.SpringContextUtil;
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

    @Bean
    public ParamLogAspect paramLogAspect() {
        return new ParamLogAspect();
    }

    @Bean
    public FrequencyAspect frequencyAspect() {
        return new FrequencyAspect();
    }

    @PostConstruct
    private void postConstruct() {
        log.info("== LOAD CAT-NEST-SPRING-STATER FINISH! ==");
    }

}
