package com.dubbo.provider;


import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
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
