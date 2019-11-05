package com.hs.slz.springservlet3;

import com.hs.slz.springservlet3.dto.Man;
import com.hs.slz.springservlet3.dto.Man.MyBeanPostProcess;
import com.hs.slz.springservlet3.dto.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan
public class AppConfig {

    @Bean
    public User getUser() {
        return new User("zhangsan", 13);
    }

    @Bean(initMethod = "setup", destroyMethod = "destory")
    public Man getMan() {
        return new Man("张三");
    }


    @Bean
    public BeanPostProcessor getMyBeanPostProcessor() {
        return new MyBeanPostProcess();
    }
}
