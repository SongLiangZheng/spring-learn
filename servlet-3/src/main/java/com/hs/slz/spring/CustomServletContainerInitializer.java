package com.hs.slz.spring;

import java.util.EnumSet;
import java.util.Set;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class CustomServletContainerInitializer implements ServletContainerInitializer {

    private final static String JAR_HELLO_URL = "/hello";

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext servletContext) {

        System.out.println("创建 helloWorldServlet...");

        ServletRegistration.Dynamic servlet = servletContext.addServlet(
                HelloWorldServlet.class.getSimpleName(),
                HelloWorldServlet.class);
        servlet.addMapping(JAR_HELLO_URL);

        System.out.println("创建 helloWorldFilter...");

        FilterRegistration.Dynamic filter = servletContext.addFilter(
                HelloWorldFilter.class.getSimpleName(), HelloWorldFilter.class);

        EnumSet<DispatcherType> dispatcherTypes = EnumSet.allOf(DispatcherType.class);
        dispatcherTypes.add(DispatcherType.REQUEST);
        dispatcherTypes.add(DispatcherType.FORWARD);

        filter.addMappingForUrlPatterns(dispatcherTypes, true, JAR_HELLO_URL);

    }
}
