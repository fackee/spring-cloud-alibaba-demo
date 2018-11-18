package com.springcloudalibabaconfig.example;


import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigApplication {

    @Autowired
    private Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(NacosConfigApplication.class,args);

    }


    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public ConfigService nacosConfigService() throws NacosException {
        return NacosFactory.createConfigService(environment.getProperty("spring.cloud.nacos.config.server-addr"));
    }

}
