package com.hs.slz.springservlet3;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        // Create the 'root' Spring application context
//        XmlWebApplicationContext rootContext = new XmlWebApplicationContext();
//        rootContext.setConfigLocation("classpath:applicationContext.xml");
        AnnotationConfigWebApplicationContext rootContext =new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);

        // Manage the lifecycle of the root application context
        container.addListener(new ContextLoaderListener(rootContext));

        // Create the dispatcher servlet's Spring application context
      AnnotationConfigWebApplicationContext dispatcherContext =new AnnotationConfigWebApplicationContext();
      dispatcherContext.register(DispatcherConfig.class);
//        XmlWebApplicationContext dispatcherContext = new XmlWebApplicationContext();
//        dispatcherContext.setConfigLocation("classpath:spring-mvc.xml");

        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher =
                container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
