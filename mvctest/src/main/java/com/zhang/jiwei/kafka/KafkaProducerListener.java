package com.zhang.jiwei.kafka;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.ProducerListener;

/**
 * Created by Administrator on 2017/5/11 0011.
 */
public class KafkaProducerListener implements ProducerListener {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerListener.class);

    /**
     * 发送消息成功后调用
     */
    @Override
    public void onSuccess(String topic, Integer partition, Object key, Object value, RecordMetadata recordMetadata) {
        logger.info("=====kafka发送数据成功(日志开始)========");
        logger.info("------topic:{}", topic);
        logger.info("------partition:{}", partition);
        logger.info("------key:{}", key);
        logger.info("------value:{}", value);
        logger.info("------recordMetadata:{}", recordMetadata);
        logger.info("======kafka发送数据成功(日志结束)===================");
    }

    /**
     * 发送消息错误后调用
     */
    @Override
    public void onError(String topic, Integer partition, Object key, Object value, Exception e) {
        logger.info("=====kafka发送数据错误(日志开始)========");
        logger.info("------topic:{}", topic);
        logger.info("------partition:{}", partition);
        logger.info("------key:{}", key);
        logger.info("------value:{}", value);
        e.printStackTrace();
    }

    @Override
    public boolean isInterestedInSuccess() {
        logger.info("///kafkaProducer监听器启动///");
        return true;
    }
}
