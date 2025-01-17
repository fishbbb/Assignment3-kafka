package com.netsurfingzone.producer;

import com.netsurfingzone.constant.ApplicationConstant;
import com.netsurfingzone.dto.InventoryRecord;
import com.netsurfingzone.dto.WarehouseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/produce")
public class WarehouseProducer{

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping("/assignWarehouse")
    public String assign(@RequestBody WarehouseMessage message) {
        try {
            kafkaTemplate.send(ApplicationConstant.TOPIC_WAREHOUSE_INVENTORY, message);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error publishing assign warehouse message";
        }
        return "Good successfully assign to Warehouse A";
    }

    //收到订单之后出库
    @PostMapping("/out")
    public String out(@RequestBody InventoryRecord record) {
        //recordService.out(record);
        try {
            kafkaTemplate.send(ApplicationConstant.TOPIC_WAREHOUSE_INVENTORY, record);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error publishing out message";
        }
        return "out successfully";
    }
}