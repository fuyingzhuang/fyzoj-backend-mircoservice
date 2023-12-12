package com.ambition.fyzojbackendjudgeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy(exposeProxy = true,proxyTargetClass = true)
@ComponentScan(basePackages = {"com.ambition"})
public class FyzojBackendJudgeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FyzojBackendJudgeServiceApplication.class, args);
    }

}
