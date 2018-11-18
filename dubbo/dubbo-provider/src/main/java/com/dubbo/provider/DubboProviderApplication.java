package com.dubbo.provider;


import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@DubboComponentScan(basePackages = "com.dubbo.provider.service")
public class DubboProviderApplication {

    /**
    *
    */
    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .web(WebApplicationType.NONE)
                .sources(DubboProviderApplication.class)
                .run(args);
    }
}
