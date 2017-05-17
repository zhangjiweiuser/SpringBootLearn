package com.zhang.jiwei.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.MessageListener;

/**
 * Created by Administrator on 2017/5/11 0011.
 */
public class KafkaConsumerServer implements MessageListener<String, String> {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerServer.class);

    /**
     * 监听器自动执行该方法
     * 消费信息
     * 自动提交offset
     * 执行业务代码
     * (high level api不提供offset管理，不能指定offset进行消费)
     */
    @Override
    public void onMessage(ConsumerRecord<String, String> record) {
        logger.info("======kafkaConsumer开始消费=========");
        String topic = record.topic();
        String key = record.key();
        String value = record.value();
        long offset = record.offset();
        int partition = record.partition();
        logger.info("------topic:{}", topic);
        logger.info("------key:{}", key);
        logger.info("------value:{}", value);
        logger.info("------offset:{}", offset);
        logger.info("------partition:{}", partition);
        logger.info("=========kafkaConsumer消费结束===========");
        System.out.println("=========kafkaConsumer消费结束===========");
    }
}
