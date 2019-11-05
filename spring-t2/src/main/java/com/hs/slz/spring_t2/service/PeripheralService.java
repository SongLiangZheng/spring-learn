package com.hs.slz.spring_t2.service;

import com.hs.slz.spring_t2.User;
import com.hs.slz.spring_t2.service.IPeripherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeripheralService implements IPeripherService {

    @Override
    public User sayHello(User user) {
        user.setName("hello "+user.getName());
        return user;
    }
}
