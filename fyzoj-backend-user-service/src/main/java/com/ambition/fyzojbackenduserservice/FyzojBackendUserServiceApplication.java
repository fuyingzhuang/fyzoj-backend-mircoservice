package com.ambition.fyzojbackenduserservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.ambition.fyzojbackenduserservice.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(exposeProxy = true,proxyTargetClass = true)
@ComponentScan(basePackages = {"com.ambition"})
public class FyzojBackendUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FyzojBackendUserServiceApplication.class, args);
    }

}
