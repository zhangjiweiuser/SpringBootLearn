package com.zhang.jiwei.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/5/9 0009.
 */
@Repository
public interface UserDao {

    List<Map<String, Object>> selectAll();
}
