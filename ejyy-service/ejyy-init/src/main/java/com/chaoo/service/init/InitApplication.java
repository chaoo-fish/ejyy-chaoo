package com.chaoo.service.init;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author chaoo
 * @Date: 2022/08/11/ 9:44
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.chaoo.service.init.mapper")
public class InitApplication {
    public static void main(String[] args) {
        SpringApplication.run(InitApplication.class,args);
    }
}
