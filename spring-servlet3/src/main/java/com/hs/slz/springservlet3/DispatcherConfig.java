package com.hs.slz.springservlet3;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@ComponentScan(value = "com.hs.slz.springservlet3.controller")
public class DispatcherConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
        gsonHttpMessageConverter.setDefaultCharset(Charset.defaultCharset());
        gsonHttpMessageConverter.setSupportedMediaTypes(
                Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN));
        converters.add(gsonHttpMessageConverter);
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
//        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
//        viewResolver.setPrefix("/");
//        viewResolver.setSuffix(".jsp");
//        registry.viewResolver(viewResolver);
        registry.jsp("/",".jsp");
    }
}
