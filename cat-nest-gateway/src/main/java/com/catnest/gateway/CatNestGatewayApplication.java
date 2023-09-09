package com.catnest.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class CatNestGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatNestGatewayApplication.class, args);
    }
}
