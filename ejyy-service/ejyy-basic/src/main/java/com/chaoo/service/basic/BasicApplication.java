package com.chaoo.service.basic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author chaoo
 * @Date: 2022/08/15/ 14:13
 */
@SpringBootApplication(
        scanBasePackages = {"com.chaoo.service.user","com.chaoo.service.basic"}
)
@MapperScan("com.chaoo.service.basic.mapper")
@EnableDiscoveryClient // 开启服务发现 nacos
public class BasicApplication {
    public static void main(String[] args) {
        SpringApplication.run(BasicApplication.class,args);
    }
}
