package com.dubbo.caller;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DubboCallerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboCallerApplication.class,args);
    }

}
