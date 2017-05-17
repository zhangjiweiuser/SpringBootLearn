package com.zhang.jiwei.chapter3;

import com.zhang.jiwei.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Administrator on 2017/5/5 0005.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockServletContext.class)
@WebAppConfiguration
public class ApplicationTest {

    private MockMvc mvc;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void testUserController() throws Exception {
        RequestBuilder request = null;
        // 1.get查询user列表，应该为空
        request = get("/users/");
        mvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

        // 2.post提交一个user
        request = post("/users/")
                .param("id", "1").param("name", "测试").param("age", "20");

        mvc.perform(request).andExpect(content().string(equalTo("success")));

        // 3.get获取user列表
        request = get("/users/");
        mvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string("[{\"id\":1,\"name\":\"测试\",\"age\":20}]"));

        // 4.put修改id为1的user
        request = put("/users/1").param("name", "测试2").param("age", "30");
        mvc.perform(request).andExpect(content().string(equalTo("success")));

        // 5. get一个id为1的user
        request = get("/users/1");
        mvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string("[{\"id\":1,\"name\":\"测试2\",\"age\":30}]"));

        // 6. del删除id为1的user
        request = delete("users/1");
        mvc.perform(request).andExpect(content().string(equalTo("success")));

        // 7. get查看user列表
        request = get("/users/");
        mvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }
}
