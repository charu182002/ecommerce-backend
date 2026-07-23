package com.ecommerce.ecart.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "order-topic", groupId = "order-group")
    public void consumeOrderCreatedEvent(String message) {

        System.out.println("Message Received : " + message);

    }
}
