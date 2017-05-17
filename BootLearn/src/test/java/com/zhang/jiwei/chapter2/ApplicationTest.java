package com.zhang.jiwei.chapter2;

import com.zhang.jiwei.service.BlogProperties;
import com.zhang.jiwei.start.Chapter2Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/5/5 0005.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Chapter2Application.class)
public class ApplicationTest {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationTest.class);

    @Autowired
    private BlogProperties blogProperties;

    @Test
    public void test() {
        System.out.println(blogProperties.getName());
        Assert.assertEquals("程序员DD", blogProperties.getName());
        Assert.assertEquals("Spring Boot教程", blogProperties.getTitle());
        Assert.assertEquals("程序员DD正在努力写Spring Boot教程", blogProperties.getDesc());
        logger.info("随机数测试输出：");
        logger.info("随机字符串 : " + blogProperties.getValue());
        logger.info("随机int : " + blogProperties.getNumber());
        logger.info("随机long : " + blogProperties.getBigNumber());
        logger.info("随机10以下 : " + blogProperties.getTest1());
        logger.info("随机10-20 : " + blogProperties.getTest2());
    }
}
