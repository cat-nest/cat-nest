package com.catnest.common.datasource.config;

import com.catnest.common.datasource.handler.EncryptHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatasourceConfig {

    @Bean
    public EncryptHandler encryptHandler() {
        return new EncryptHandler();
    }


}
