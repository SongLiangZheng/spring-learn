package com.hs.slz.spring.cmp;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("==========MyListener==========");
        System.out.println("contextInitialized");
        System.out.println("==========MyListener==========");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("==========MyListener==========");
        System.out.println("contextDestroyed");
        System.out.println("==========MyListener==========");
    }
}
