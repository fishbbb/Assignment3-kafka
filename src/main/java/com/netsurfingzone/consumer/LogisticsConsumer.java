package com.netsurfingzone.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netsurfingzone.constant.ApplicationConstant;
import com.netsurfingzone.dto.Goods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class LogisticsConsumer {

    private static final Logger logger = LoggerFactory.getLogger(com.netsurfingzone.consumer.KafkaConsumer.class);


    @KafkaListener(groupId = ApplicationConstant.GROUP_ID_JSON, topics = ApplicationConstant.TOPIC_LOGISTICS_ARRIVAL, containerFactory = ApplicationConstant.KAFKA_LISTENER_CONTAINER_FACTORY)
    private void processArrivalMessage(Goods message) throws JsonProcessingException {
        // 处理到达消息的逻辑
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(message);
        logger.info("Json message received using Kafka listener " + jsonString);
        // 可以在这里调用相关的业务逻辑处理
    }

    @KafkaListener(groupId = ApplicationConstant.GROUP_ID_JSON, topics = ApplicationConstant.TOPIC_LOGISTICS_UNLOADING, containerFactory = ApplicationConstant.KAFKA_LISTENER_CONTAINER_FACTORY)
    private void processUnloadMessage(Goods message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(message);
        logger.info("Json message received using Kafka listener " + jsonString);
        // 可以在这里调用相关的业务逻辑处理
    }

    @KafkaListener(groupId = ApplicationConstant.GROUP_ID_JSON, topics = ApplicationConstant.TOPIC_LOGISTICS_INSPECTION, containerFactory = ApplicationConstant.KAFKA_LISTENER_CONTAINER_FACTORY)
    private void processInspectionMessage(Goods message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(message);
        logger.info("Json message received using Kafka listener " + jsonString);
        // 可以在这里调用相关的业务逻辑处理
    }
}