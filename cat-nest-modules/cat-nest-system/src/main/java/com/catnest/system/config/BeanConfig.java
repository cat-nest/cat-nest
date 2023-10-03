package com.catnest.system.config;

import com.catnest.common.datasource.handler.EncryptHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Slf4j
@Import(EncryptHandler.class)
public class BeanConfig {

}
