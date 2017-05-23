package com.zhang.jiwei.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2017/5/23 0023.
 */
public class ProxyTest {

    public static void main(String[] args) {
        Hello hello = new HelloImpl();
        DynamicProxy dynamicProxy = new DynamicProxy(hello);

//        Hello helloProxy = (Hello) Proxy.newProxyInstance(hello.getClass().getClassLoader(),
//                hello.getClass().getInterfaces(),
//                dynamicProxy);
//        helloProxy.say("jack");
        Hello helloProxy = dynamicProxy.getProxy();
        helloProxy.say("jack");
    }
}
