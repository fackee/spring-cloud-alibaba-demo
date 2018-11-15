package com.springcloudalibabaconfig.example;


import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.client.config.NacosConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConfigController {


    @Value("${service.discovery}")
    private String serviceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NacosConfigService nacosConfigService;

    @RequestMapping(value = "/config/get")
    public String config(){
        return restTemplate.getForObject(serviceUrl,String.class);
    }


    @RequestMapping(value = "/config/update")
    public String updateCOnfig(String configKey,String configValue){
        try {
            nacosConfigService.publishConfig("","",configKey + "=" + configValue);
        } catch (NacosException e) {
            e.printStackTrace();
        }
        return "update config to:"+configKey + "|" + configValue;
    }


}
