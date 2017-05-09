package com.zhang.jiwei.controller;

import java.util.List;
import java.util.Map;

import com.zhang.jiwei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/5/8 0008.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/getUser")
    public List<Map<String, Object>> getUser() {
        return userService.selectAll();
    }

}
