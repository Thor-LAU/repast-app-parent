package com.aaa.lau.repast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/3/17 11:22
 * @Description
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ApplicationRun4081 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun4081.class, args);
    }

}
