package com.hs.slz.spring.service.impl;

import com.hs.slz.spring.service.IUserService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@Service
public class UserService implements IUserService {
    @Override
    public void task1() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        Object version = requestAttributes.getAttribute("version", RequestAttributes.SCOPE_REQUEST);
        System.out.println("task1: "+version);
    }

    @Override
//    @Async
    public void task2() {
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        Object version = requestAttributes.getAttribute("version", RequestAttributes.SCOPE_REQUEST);
        System.out.println("task2: "+version);
    }
}
