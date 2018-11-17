package com.springcloudalibabaconfig.example;


import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.client.config.NacosConfigService;
import org.bouncycastle.crypto.tls.SRTPProtectionProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope
public class ConfigController {


    /**
    * nacos-config's dataId = ${prefix}-${spring.profile.active}.${file-extentions}
     * ${prefix}=spring.cluod.nacos.config.prefix,default is the applicationName
     * ${spring.profile.prefix}
     * ${file-extentions}=properties or yaml
    */
    @Value("${spring.application.name}")
    private String applicaionName;

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
            nacosConfigService.publishConfig(applicaionName+".yaml","DEFAULT_GROUP",configKey + "=" + configValue);
        } catch (NacosException e) {
            e.printStackTrace();
        }
        return "update config to:"+configKey + "|" + configValue;
    }


}
