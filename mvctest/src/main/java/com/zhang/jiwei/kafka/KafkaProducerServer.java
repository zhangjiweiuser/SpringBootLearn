package com.zhang.jiwei.kafka;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutionException;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * Created by Administrator on 2017/5/11 0011.
 */
@Component
public class KafkaProducerServer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * @param topic        主题
     * @param value        messageValue
     * @param ifPartition  是否使用分区 0：是，1：不是
     * @param partitionNum 分区数，如果是否使用分区为0，分区数必须大于0
     * @param role         角色，bbc app
     */
    public Map<String, Object> sendMesForTemplate(String topic, Object value, String ifPartition, Integer partitionNum, String role) {
        String key = role + "-" + value.hashCode();
        String valueString = JSON.toJSONString(value);
        if (ifPartition.equals("0")) {
            // 表示使用分区
            int partitionIndex = getPartitionIndex(key, partitionNum);
            ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send(topic, partitionIndex, key, valueString);
            return checkProRecord(result);
        }
        ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send(topic, key, valueString);
        return checkProRecord(result);
    }

    /**
     * 根据key值获取分区索引
     */
    private int getPartitionIndex(String key, int partitionNum) {
        if (null == key) {
            Random random = new Random();
            return random.nextInt(partitionNum);
        }
        int result = Math.abs(key.hashCode()) % partitionNum;
        return result;
    }

    private Map<String, Object> checkProRecord(ListenableFuture<SendResult<String, String>> result) {
        Map<String, Object> map = new HashMap<>();
        if (null != result) {
            try {
                // 检查result结果集
                SendResult<String, String> r = result.get();
                // 检查recordMetadata的offset数据，不检查producerRecord
                Long offsetIndex = r.getRecordMetadata().offset();
                if (null != offsetIndex && offsetIndex >= 0) {
                    map.put("code", KafkaMesConstant.SUCCESS_CODE);
                    map.put("message", KafkaMesConstant.SUCCESS_MES);
                    return map;
                } else {
                    map.put("code", KafkaMesConstant.KAFKA_NO_OFFSET_CODE);
                    map.put("message", KafkaMesConstant.KAFKA_NO_OFFSET_MES);
                    return map;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                map.put("code", KafkaMesConstant.KAFKA_SEND_ERROR_CODE);
                map.put("message", KafkaMesConstant.KAFKA_SEND_ERROR_MES);
                return map;
            } catch (ExecutionException e) {
                e.printStackTrace();
                map.put("code", KafkaMesConstant.KAFKA_SEND_ERROR_CODE);
                map.put("message", KafkaMesConstant.KAFKA_SEND_ERROR_MES);
                return map;
            }
        } else {
            map.put("code", KafkaMesConstant.KAFKA_NO_RESULT_CODE);
            map.put("message", KafkaMesConstant.KAFKA_NO_RESULT_MES);
            return map;
        }
    }
}
