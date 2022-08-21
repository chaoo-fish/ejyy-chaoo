package com.openlab.service.notice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.openlab.service.notice.mapper")
@EnableDiscoveryClient
public class NoticeApplication {
    public static void main(String[] args) {
        SpringApplication.run(NoticeApplication.class, args);
    }
}

