package com.catnest.user;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.catnest.user.mapper")
public class CatNestUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatNestUserApplication.class, args);
    }

}
