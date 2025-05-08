package com.btsy.intw.service.kafka;

import com.btsy.intw.configuration.KafkaConfigProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaBetProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaConfigProperties kafkaConfigProperties;

    public KafkaBetProducerService(KafkaTemplate<String, String> kafkaTemplate, KafkaConfigProperties kafkaConfigProperties) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaConfigProperties = kafkaConfigProperties;
    }

    public void publishBet(String message) {
        kafkaTemplate.send(kafkaConfigProperties.getTopic(), message);
    }

    public void publishBetToDlq(String message) {
        kafkaTemplate.send(kafkaConfigProperties.getDlqTopic(), message);
    }
}