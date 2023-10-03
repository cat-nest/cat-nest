package com.catnest.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CatNestAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatNestAdminApplication.class, args);
    }

}
