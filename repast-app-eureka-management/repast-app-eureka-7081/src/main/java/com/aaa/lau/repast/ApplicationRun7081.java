package com.aaa.lau.repast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Program: 20200309-repast-app-parent
 * @Description:
 * @Author: Thor Lau
 * @Create: 2020-03-09 22:41
 **/
@SpringBootApplication
@EnableEurekaServer
public class ApplicationRun7081 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun7081.class, args);
    }
}
