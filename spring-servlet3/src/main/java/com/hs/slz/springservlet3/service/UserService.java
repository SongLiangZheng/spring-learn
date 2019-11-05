package com.hs.slz.springservlet3.service;

import com.hs.slz.springservlet3.dto.User;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    public String sayHello(User user) {
        return "hello " + user.getName();
    }
}
