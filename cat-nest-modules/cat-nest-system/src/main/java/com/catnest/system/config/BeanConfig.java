package com.catnest.system.config;

import com.catnest.common.datasource.handler.EncryptHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Slf4j
public class BeanConfig {

    /**
     * 加密密钥
     */
    @Value("${cat-nest.datasource.securityKey}")
    public String securityKey = "12345678abcdefgh";


    @Bean
    public EncryptHandler encryptHandler() {
        return new EncryptHandler(securityKey);
    }

}
