package com.ambition.fyzojbackendqusetionservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.ambition.fyzojbackendqusetionservice.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(exposeProxy = true,proxyTargetClass = true)
@ComponentScan(basePackages = {"com.ambition"})
public class FyzojBackendQusetionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FyzojBackendQusetionServiceApplication.class, args);
    }

}
