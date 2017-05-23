package com.zhang.jiwei.aop;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by Administrator on 2017/5/23 0023.
 */
public class Client {

    public static void main(String[] args) {
        // 创建代理工厂
        ProxyFactory proxyFactory = new ProxyFactory();
        // 织入目标类对象
        proxyFactory.setTarget(new GreetingImpl());
//        // 添加前置增强
//        proxyFactory.addAdvice(new GreetingBeforeAdvice());
//        // 添加后置增强
//        proxyFactory.addAdvice(new GreetingAfterAdvice());
//        proxyFactory.addAdvice(new GreetingBeforeAndAfterAdvice());
        proxyFactory.addAdvice(new GreetingAroundAdvice());
        Greeting greeting = (Greeting) proxyFactory.getProxy();
        greeting.sayHello("jack");
    }
}
