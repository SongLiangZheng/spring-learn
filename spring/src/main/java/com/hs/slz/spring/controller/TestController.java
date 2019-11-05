package com.hs.slz.spring.controller;

import com.hs.slz.spring.dto.Man;
import com.hs.slz.spring.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    private User user;

    @RequestMapping("/")
    public String home() {
        System.out.println();
        return "home";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "test " + user;
    }

    @RequestMapping("/user")
    @ResponseBody
    public User user() {
        return user;
    }


    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping("/showMans")
    @ResponseBody
    public Man showMans() {
        return (Man) applicationContext.getBean("man");
    }

    @RequestMapping("/home")
    public String html() {
        return "home";
    }


}
