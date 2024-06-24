package com.netsurfingzone.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netsurfingzone.constant.ApplicationConstant;
import com.netsurfingzone.dto.WarehouseMessage;
import com.netsurfingzone.service.Impl.InventoryServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class WarehouseConsumer {
    private static final Logger logger = LoggerFactory.getLogger(com.netsurfingzone.consumer.KafkaConsumer.class);

    @Autowired
    private InventoryServiceImpl inventoryService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @KafkaListener(groupId = ApplicationConstant.GROUP_ID_JSON, topics = ApplicationConstant.TOPIC_WAREHOUSE_INVENTORY, containerFactory = ApplicationConstant.KAFKA_LISTENER_CONTAINER_FACTORY)
    private void processAssignMessage(WarehouseMessage message) throws JsonProcessingException {
        // 处理到达消息的逻辑
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(message);
        logger.info("Json message received using Kafka listener " + jsonString);
        messagingTemplate.convertAndSend("/ws","Json message received using Kafka listener " + jsonString);
    }

    @KafkaListener(groupId = ApplicationConstant.GROUP_ID_JSON, topics = ApplicationConstant.TOPIC_WAREHOUSE_OUTBOUND, containerFactory = ApplicationConstant.KAFKA_LISTENER_CONTAINER_FACTORY)
    private void processOutMessage(WarehouseMessage message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(message);
        logger.info("Json message received using Kafka listener " + jsonString);
        //TODO:输出给web
        messagingTemplate.convertAndSend("/ws","Json message received using Kafka listener " + jsonString);
    }
    
}