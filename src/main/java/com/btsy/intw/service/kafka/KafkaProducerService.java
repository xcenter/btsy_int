package com.btsy.intw.service.kafka;

import com.btsy.intw.configuration.KafkaConfigProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private KafkaConfigProperties kafkaConfigProperties;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        kafkaTemplate.send(kafkaConfigProperties.getTopic(), message);
    }
}