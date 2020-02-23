package com.hs.slz.spring.cmp;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@Aspect
@Component
public class ServiceAspect {
    @Pointcut("execution(* com.hs.slz.spring.service.*.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void before(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        Object version = requestAttributes.getAttribute("version", RequestAttributes.SCOPE_REQUEST);
        System.out.println("ServiceAspect: "+version);
    }
}
