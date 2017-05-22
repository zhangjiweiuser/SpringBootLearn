package com.zhang.jiwei.entity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by Administrator on 2017/5/19 0019.
 */
public class UserTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<User> userList = new ArrayList() {{
            add(new User(1, "zhangsan1"));
            add(new User(2, "zhangsan2"));
            add(new User(3, "zhangsan3"));
            add(new User(4, "zhangsan4"));
            add(new User(5, "zhangsan5"));
        }};

        List<User> userList1 = new ArrayList<>();
        List<User> userList2 = new ArrayList<>();
        List<User> userList1Src = deepCopy(userList);
        for(User user : userList1Src){
            if(user.getId()<4){
                user.setValue(user.getName());
                userList1.add(user);
            }
        }
        List<User> userList2Src = deepCopy(userList);
        for(User user : userList2Src){
            if(user.getId()%2==1){
                user.setValue(user.getName()+"aaaaa");
                userList2.add(user);
            }
        }

        userList1.forEach(u-> System.out.println(JSONObject.toJSONString(u)));
        System.out.println("====================");
        userList2.forEach(u-> System.out.println(JSONObject.toJSONString(u)));
    }

    public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);
        outputStream.writeObject(src);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream inputStream = new ObjectInputStream(byteArrayInputStream);
        return (List<T>) inputStream.readObject();
    }
}
