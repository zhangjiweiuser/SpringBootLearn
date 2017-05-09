package com.zhang.jiwei.controller;

import com.zhang.jiwei.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/5/8 0008.
 */
@RestController
public class HelloController {

    @RequestMapping(path = "/hello/{player}")
    public User message(@PathVariable String player) {
        User msg = new User(player, "Hello " + player);
        return msg;
    }

    @RequestMapping(path = "/buhao")
    public String buhao() {
        return "buhao";
    }
}
