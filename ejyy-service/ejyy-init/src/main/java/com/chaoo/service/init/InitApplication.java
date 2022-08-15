package com.chaoo.service.init;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author chaoo
 * @Date: 2022/08/11/ 9:44
 */
@SpringBootApplication
@MapperScan("com.chaoo.service.init.mapper")
public class InitApplication {
    public static void main(String[] args) {
        SpringApplication.run(InitApplication.class,args);
    }
}
