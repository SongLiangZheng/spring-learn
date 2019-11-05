package com.hs.slz.spring_t2_both.service;

import com.hs.slz.spring_t2_both.User;
import com.hundsun.jresplus.remoting.impl.annotation.Service;
import com.hundsun.jresplus.remoting.impl.annotation.ServiceModule;
import com.hundsun.jresplus.remoting.impl.annotation.ServiceParam;
import com.hundsun.jresplus.remoting.impl.annotation.ServiceResult;

@ServiceModule
public interface IPeripherService {

    @Service(functionId = "11110", desc = "test")
    @ServiceResult("resp")
    User sayHello(@ServiceParam("user") User user);
}
