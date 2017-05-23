package com.zhang.jiwei.proxy;

/**
 * Created by Administrator on 2017/5/23 0023.
 */
public class HelloImpl implements Hello {

    @Override
    public void say(String name) {
        System.out.println("hello " + name);
    }
}
