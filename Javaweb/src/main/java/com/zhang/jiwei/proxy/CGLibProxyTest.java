package com.zhang.jiwei.proxy;

/**
 * Created by Administrator on 2017/5/23 0023.
 */
public class CGLibProxyTest {

    public static void main(String[] args) {
        Hello helloProxy = CGLibProxy.getInstance().getProxy(HelloImpl.class);
        helloProxy.say("jack");
    }
}
