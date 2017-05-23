package com.zhang.jiwei.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * Created by Administrator on 2017/5/23 0023.
 */
public class GreetingAfterAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object result, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("after");
    }
}
