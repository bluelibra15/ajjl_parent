package com.ajjl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.ajjl.dao")
@EnableTransactionManagement
@EnableCaching //开启缓存的注解
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
