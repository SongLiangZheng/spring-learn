package com.hs.slz.spring.controller;

import com.hs.slz.spring.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.FrameworkServlet;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Controller
@RequestMapping("/context")
public class ServletContextController {
    @Autowired
    private IUserService userService;

//    @Autowired
//    protected ThreadPoolTaskExecutor exec;


//    ContextAwarePoolExecutor exec = new ContextAwarePoolExecutor();
//    {
//        exec.initialize();
//        exec.setCorePoolSize(3);
//    }

    @RequestMapping("/thread")
    @ResponseBody
    public long thread() throws InterruptedException {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        System.out.println(requestAttributes);
        Thread t = new Thread(() -> {
            RequestAttributes requestAttributes1 = RequestContextHolder.getRequestAttributes();
            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            Object version = servletRequestAttributes.getAttribute("version", RequestAttributes.SCOPE_REQUEST);
            System.out.println(version);
        });
        t.start();
//        Thread.sleep(100);
        t.join();
        return 1;
    }
    ExecutorService exec = Executors.newFixedThreadPool(3);

    @RequestMapping("/threadPool")
    @ResponseBody
    public long test() {
        long start = System.currentTimeMillis();

        Future<?> submit1 = exec.submit(() -> {
            userService.task1();
        });
        Future<?> submit2 = exec.submit(() -> {
            userService.task2();
        });
        FrameworkServlet F;
        try {
            submit1.get();
            submit2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        long end = System.currentTimeMillis();

        return (end - start);

    }


}
