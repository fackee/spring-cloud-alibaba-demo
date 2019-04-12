package com.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.api.service.SafeCheckService;

import java.util.concurrent.ThreadLocalRandom;

@Service(version = "${dubbo.application.version}")
public class SafeCheckServiceImpl implements SafeCheckService {

    @Override
    public boolean isSafe(String userName) {
        int isSafe = ThreadLocalRandom.current().nextInt(2);
        System.out.println("======================================="+isSafe);
        return isSafe == 0 ? true : false;
    }

    @Override
    public void test() {
        System.out.println("======test");
    }
}
