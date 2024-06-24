package com.netsurfingzone.producer;

import com.netsurfingzone.constant.ApplicationConstant;
import com.netsurfingzone.dto.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produce")
public class LogisticsProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    // 货物到达
    @PostMapping("/arrival")
    public String arrival(@RequestBody Goods message) {
        try {
            kafkaTemplate.send(ApplicationConstant.TOPIC_LOGISTICS_ARRIVAL, message);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error publishing arrival message";
        }
        return "Goods arrival successfully";
    }

    // 货物卸货
    @PostMapping("/unload")
    public String unload(@RequestBody Goods message) {
        try {
            kafkaTemplate.send(ApplicationConstant.TOPIC_LOGISTICS_UNLOADING, message);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error publishing unload message";
        }
        return "Goods unload successfully";
    }

    @PostMapping("/inspection")
    public String inspection(@RequestBody Goods message) {
        try {
            // 模拟执行货物检查的具体逻辑

            // 1. 每件货物在卸货时进行检查，以确保其状况良好并与运输细节相符。
            boolean isConditionGood = true; // 假设检查货物状态的逻辑
            if (!isConditionGood) {
                return "Goods inspection found discrepancies, further handling required.";
            }

            // 2. 记录并报告任何损坏或差异，交由物流团队进一步处理。
            boolean isDamaged = false; // 假设检查货物损坏的逻辑
            if (isDamaged) {
                return "Goods inspection found damages, further handling required.";
            }

            // 3. 验证并记录必要的文档，例如发票、提单和保修证书。
            boolean documentsVerified = true; // 假设验证文档的逻辑
            if (!documentsVerified) {
                return "Documents verification failed, inspection incomplete.";
            }

            // 4. 将信息输入仓库管理系统以进行跟踪和库存管理。
            boolean enteredIntoSystem = true; // 假设将信息输入系统的逻辑
            if (!enteredIntoSystem) {
                return "Failed to enter information into warehouse management system.";
            }

            // 5. 使用 RFID 标签对货物进行分类和分类。
            boolean rfidUsed = true; // 假设使用 RFID 标签的逻辑
            if (!rfidUsed) {
                return "Failed to use RFID tags for goods classification.";
            }

            // 假设检查通过，记录相关文档信息到系统
            System.out.println("Documenting invoices, bills of lading, and warranty certificates.");
            // 假设使用 RFID 标签对货物进行分类和管理
            System.out.println("Using RFID tags for classification and tracking of goods.");

            return "Inspection completed successfully for goods: " + message;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error performing inspection for goods: " + message;
        }
    }
}