package com.zhang.jiwei.kafka;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;

/**
 * Created by Administrator on 2017/5/11 0011.
 */
public class KafkaProducerTest {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"classpath:applicationContext.xml"});
        KafkaMessageListenerContainer container = (KafkaMessageListenerContainer) ac.getBean("messageListenerContainerTrade");
        container.start();
        KafkaProducerServer producerServer = ac.getBean(KafkaProducerServer.class);
        String topic = "defaultTopic";
        String value = "one defaultTopic";
        String ifPartition = "0";
        Integer partitionNum = 3;
        String role = "test";
        Map<String, Object> res = producerServer.sendMesForTemplate(topic, value, ifPartition, partitionNum, role);
        System.out.println("测试结果如下：--------");
        String message = (String) res.get("message");
        Integer code = (Integer) res.get("code");
        System.out.println("code:" + code);
        System.out.println("message:" + message);


    }
}
