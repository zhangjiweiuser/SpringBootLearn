package com.zhang.jiwei.controller;

import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * Created by Administrator on 2017/5/8 0008.
 */
@RestController
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private RequestMappingHandlerMapping handlerMapping;

    @RequestMapping(path = "/index")
    public void message() {
        Map<RequestMappingInfo, HandlerMethod> map = handlerMapping.getHandlerMethods();
        for (Entry<RequestMappingInfo, HandlerMethod> entry : map.entrySet()) {
            logger.info(entry.getKey() + "==" + entry.getValue());
        }
    }

}
