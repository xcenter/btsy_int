package com.btsy.intw.service.kafka;

import com.btsy.intw.configuration.KafkaConfigProperties;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {


    @KafkaListener(topics = "${kafka.topic}", groupId = "${kafka.groupId}")
    public void consumeMessage(String message) {
        System.out.println("Consumed message: " + message);
    }
}