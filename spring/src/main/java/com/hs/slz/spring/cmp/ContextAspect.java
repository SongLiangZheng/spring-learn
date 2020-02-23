package com.hs.slz.spring.cmp;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class ContextAspect {

    @Pointcut("execution(* com.hs.slz.spring.controller.*.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void before(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        RequestContextHolder.setRequestAttributes(servletRequestAttributes, true);
        servletRequestAttributes.setAttribute("version", 1, RequestAttributes.SCOPE_REQUEST);
    }
}
