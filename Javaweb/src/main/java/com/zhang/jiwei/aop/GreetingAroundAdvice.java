package com.zhang.jiwei.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by Administrator on 2017/5/23 0023.
 */
public class GreetingAroundAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        before();
        Object result = invocation.proceed();
        after();
        return result;
    }
    private void before() {
        System.out.println("before");
    }

    private void after() {
        System.out.println("after");
    }
}
