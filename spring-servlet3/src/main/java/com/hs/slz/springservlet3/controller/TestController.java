package com.hs.slz.springservlet3.controller;

import com.hs.slz.springservlet3.dto.Man;
import com.hs.slz.springservlet3.dto.User;
import com.hs.slz.springservlet3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    private User user;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String homepage() {
        return "home";
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/user")
    @ResponseBody
    public User user() {
        System.out.println(userService.sayHello(user));
        return user;
    }




}
