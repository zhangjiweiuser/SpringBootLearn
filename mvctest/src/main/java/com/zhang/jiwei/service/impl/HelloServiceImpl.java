package com.zhang.jiwei.service.impl;

import com.zhang.jiwei.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/8 0008.
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}
