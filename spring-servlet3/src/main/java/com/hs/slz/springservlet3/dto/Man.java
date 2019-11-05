package com.hs.slz.springservlet3.dto;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Man implements BeanNameAware, ApplicationContextAware, InitializingBean,
        DisposableBean {
    private String name;

    public Man() {
        System.out.println("第一步：实例化类");
    }
    public Man(String name) {
        this.name=name;
        System.out.println("第一步：带参数-name实例化类");
    }


    public void setName(String name) {
        System.out.println("第二步：设置属性");
        this.name = name;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("第三步：设置bean的名称也就是spring容器中的名称，也就是id值" + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("第四步：了解工厂信息ApplicationContext");
    }
    //第五步执行初始化之前执行的方法


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("第六步：属性设置后执行的方法");
    }

    public void setup() {
        System.out.println("第七步：执行自己配置的初始化方法");
    }
    //第八步执行初始化之后执行的方法
    public void run() {
        System.out.println("第九步：执行自身的业务方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("第十步：执行spring的销毁方法");
    }

    public void destory() {
        System.out.println("第十一步：执行自己配置的销毁方法");
    }


    public static class MyBeanPostProcess implements BeanPostProcessor {

        //后处理bean，最重要的两步
        @Override
        public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException {
            if(bean instanceof Man)
                System.out.println("第五步：初始化之前执行的方法");
            return bean;
        }

        @Override
        public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {
            if(bean instanceof Man)
                System.out.println("第八步：执行初始化之后的方法");
            return bean;
        }
    }
}

