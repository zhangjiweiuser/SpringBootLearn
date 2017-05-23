package com.zhang.jiwei.aop;

/**
 * Created by Administrator on 2017/5/23 0023.
 */
public class GreetingImpl implements Greeting {

    @Override
    public void sayHello(String name) {
        before();
        System.out.println("hello " + name);
        after();
    }

    private void before() {
        System.out.println("before");
    }

    private void after() {
        System.out.println("after");
    }
}
