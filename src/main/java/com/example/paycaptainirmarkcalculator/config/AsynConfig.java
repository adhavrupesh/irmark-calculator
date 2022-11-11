package com.example.paycaptainirmarkcalculator.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;

import java.util.concurrent.Executor;

@Configuration
public class AsynConfig extends AsyncConfigurerSupport {

    @Autowired
    private AsyncExceptionHandler asyncExceptionHandler;

    @Override
    public Executor getAsyncExecutor() {
        return super.getAsyncExecutor();
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return asyncExceptionHandler;
    }
}
