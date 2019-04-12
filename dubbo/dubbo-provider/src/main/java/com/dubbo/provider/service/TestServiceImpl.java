package com.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.api.service.TestService;

/**
 * @author zhujianxin
 * @date 2019/3/28.
 */
@Service(version = "${dubbo.application.version}")
public class TestServiceImpl implements TestService {
    @Override
    public void test() {
        System.out.println("====testService====testmethod");
    }
}
