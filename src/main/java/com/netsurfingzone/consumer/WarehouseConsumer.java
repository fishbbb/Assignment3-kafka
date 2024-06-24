package com.netsurfingzone.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netsurfingzone.constant.ApplicationConstant;
import com.netsurfingzone.dto.WarehouseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class WarehouseConsumer {
    private static final Logger logger = LoggerFactory.getLogger(com.netsurfingzone.consumer.KafkaConsumer.class);


    @KafkaListener(groupId = ApplicationConstant.GROUP_ID_JSON, topics = ApplicationConstant.TOPIC_WAREHOUSE_INVENTORY, containerFactory = ApplicationConstant.KAFKA_LISTENER_CONTAINER_FACTORY)
    private void processAssignMessage(WarehouseMessage message) throws JsonProcessingException {
        // 处理到达消息的逻辑
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(message);
        logger.info("Json message received using Kafka listener " + jsonString);
        //TODO:输出给web
    }

    @KafkaListener(groupId = ApplicationConstant.GROUP_ID_JSON, topics = ApplicationConstant.TOPIC_WAREHOUSE_INVENTORY, containerFactory = ApplicationConstant.KAFKA_LISTENER_CONTAINER_FACTORY)
    private void processSendMessage(WarehouseMessage message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(message);
        logger.info("Json message received using Kafka listener " + jsonString);
        //TODO:输出给web
    }

    @KafkaListener(groupId = ApplicationConstant.GROUP_ID_JSON, topics = ApplicationConstant.TOPIC_WAREHOUSE_OUTBOUND, containerFactory = ApplicationConstant.KAFKA_LISTENER_CONTAINER_FACTORY)
    private void processOutMessage(WarehouseMessage message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(message);
        logger.info("Json message received using Kafka listener " + jsonString);
        //TODO:输出给web
    }
    
}