package com.catnest.system;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.catnest.system.mapper")
public class CatNestSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatNestSystemApplication.class, args);
    }

}
