package com.hs.slz.spring.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

@Configuration
@EnableAsync
public class ExecutorConfig {
//        implements AsyncConfigurer {

//    @Override
//    public Executor getAsyncExecutor() {
//        return getExecutor();
//    }

    @Bean
    public ThreadPoolTaskExecutor getExecutor(){
        ThreadPoolTaskExecutor threadPool = new ContextAwarePoolExecutor();
//        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
        threadPool.initialize();
        threadPool.setCorePoolSize(3);
        threadPool.setMaxPoolSize(10);
        return threadPool;
    }
}
