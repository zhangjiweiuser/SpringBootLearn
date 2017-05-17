package com.zhang.jiwei.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Administrator on 2017/5/5 0005.
 */
@SpringBootApplication(scanBasePackages = "com.zhang.jiwei.controller")
public class Chapter1Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter1Application.class, args);
    }
}
