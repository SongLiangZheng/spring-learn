package com.hs.slz.spring_t2_peripheral.service;

import com.hs.slz.spring_t2_peripheral.User;
import org.springframework.stereotype.Service;

@Service
public class PeripheralService implements IPeripherService {

    @Override
    public User sayHello(User user) {
        user.setName("hello "+user.getName());
        return user;
    }
}
