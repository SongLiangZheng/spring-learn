package com.hs.slz.spring_t2_peripheral.controller;

import com.hs.slz.spring_t2_peripheral.User;
import com.hs.slz.spring_t2_peripheral.service.IPeripherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
