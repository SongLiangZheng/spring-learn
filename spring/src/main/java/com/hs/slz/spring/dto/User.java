package com.hs.slz.spring.dto;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@Data
public class User implements BeanNameAware, ApplicationContextAware, InitializingBean,
        DisposableBean {
    private String name;
    private String age;

    public User(String name, String age) {
        this.name=name;
        this.age=age;
    }

    public void setName(String name) {
        System.out.println("Man第二步：设置属性name");
        this.name = name;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("Man第三步：设置bean的名称也就是spring容器中的名称，也就是id值" + s);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Man第四步：了解工厂信息ApplicationContext");
    }
    //Man第五步执行初始化之前执行的方法


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Man第六步：属性设置后执行的方法");
    }

    public void setup() {
        System.out.println("Man第七步：执行自己配置的初始化方法");
    }
    //Man第八步执行初始化之后执行的方法
    public void run() {
        System.out.println("Man第九步：执行自身的业务方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Man第十步：执行spring的销毁方法");
    }

    public void destory() {
        System.out.println("Man第十一步：执行自己配置的销毁方法");
    }

}
