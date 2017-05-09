package com.zhang.jiwei.service.impl;

import java.util.List;
import java.util.Map;

import com.zhang.jiwei.dao.UserDao;
import com.zhang.jiwei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/9 0009.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<Map<String, Object>> selectAll() {
        return userDao.selectAll();
    }
}
