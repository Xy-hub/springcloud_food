package com.springcloud.food;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 普通用户登录和管理员登录公共类
 */
@SpringBootApplication
@MapperScan("com.springcloud.food.dao")
public class AccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class,args);
    }
}
