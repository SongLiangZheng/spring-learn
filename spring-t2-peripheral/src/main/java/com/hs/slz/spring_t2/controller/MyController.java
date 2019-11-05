package com.hs.slz.spring_t2.controller;

import com.google.gson.Gson;
import com.hs.slz.spring_t2.User;
import com.hs.slz.spring_t2.service.IPeripherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.XmlWebApplicationContext;
@Controller
public class MyController {

    @Autowired
    private IPeripherService peripherService;

    @RequestMapping("/hello")
    @Autowired
    @ResponseBody
    private User hello(){
        return peripherService.sayHello(new User("zhangsan",13));
    }

    @RequestMapping("/")
    @Autowired
    private String home(){
        return "home-slz";
    }

}
