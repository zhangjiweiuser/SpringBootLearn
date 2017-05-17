package com.zhang.jiwei.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Administrator on 2017/5/5 0005.
 */
@SpringBootApplication(scanBasePackages = "com.zhang.jiwei.controller,com.zhang.jiwei.service")
public class Chapter2Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter2Application.class, args);
    }
}
