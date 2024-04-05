package com.sigmaka.kafkasubscriber.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @KafkaListener(topics= "product-topic", groupId = "sigmaka-group")
    public void listenProduct(String message){
        System.out.println("Received product-topic message: " + message);
    }

    @KafkaListener(topics= "category-topic", groupId = "sigmaka-group")
    public void listenCategory(String message){
        System.out.println("Received category-topic message: " + message);
    }
}
