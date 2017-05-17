package com.zhang.jiwei.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/5/5 0005.
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello")
    public String hello() {
        return "Hello world";
    }
}
