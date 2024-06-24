package com.netsurfingzone.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netsurfingzone.constant.ApplicationConstant;
import com.netsurfingzone.dto.GoodMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

@Component
public class LogisticsConsumer {

    private static final Logger logger = LoggerFactory.getLogger(com.netsurfingzone.consumer.KafkaConsumer.class);

    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @KafkaListener(groupId = ApplicationConstant.GROUP_ID_JSON, topics = ApplicationConstant.TOPIC_LOGISTICS_ARRIVAL, containerFactory = ApplicationConstant.KAFKA_LISTENER_CONTAINER_FACTORY)
    private void processArrivalMessage(GoodMessage message) throws IOException {
        // 处理到达消息的逻辑
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(message);
        logger.info("Json message received using Kafka listener " + jsonString);
        // 可以在这里调用相关的业务逻辑处理
        // Send the message to WebSocket clients
        messagingTemplate.convertAndSend("/ws","Json message received using Kafka listener " + jsonString);
    }

    @KafkaListener(groupId = ApplicationConstant.GROUP_ID_JSON, topics = ApplicationConstant.TOPIC_LOGISTICS_UNLOADING, containerFactory = ApplicationConstant.KAFKA_LISTENER_CONTAINER_FACTORY)
    private void processUnloadMessage(GoodMessage message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(message);
        logger.info("Json message received using Kafka listener " + jsonString);
        messagingTemplate.convertAndSend("/ws","Json message received using Kafka listener " + jsonString);
        // 可以在这里调用相关的业务逻辑处理
    }

    @KafkaListener(groupId = ApplicationConstant.GROUP_ID_JSON, topics = ApplicationConstant.TOPIC_LOGISTICS_INSPECTION, containerFactory = ApplicationConstant.KAFKA_LISTENER_CONTAINER_FACTORY)
    private void processInspectionMessage(GoodMessage message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(message);
        logger.info("Json message received using Kafka listener " + jsonString);
        // 可以在这里调用相关的业务逻辑处理
        messagingTemplate.convertAndSend("/ws","Json message received using Kafka listener " + jsonString);
    }
}