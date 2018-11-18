package com.dubbo.caller.controller;


import com.dubbo.caller.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {


    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login")
    public String login(String userName,String password){
        return loginService.login(userName,password);
    }

}
