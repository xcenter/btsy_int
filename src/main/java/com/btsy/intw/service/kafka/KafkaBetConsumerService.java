package com.btsy.intw.service.kafka;

import com.btsy.intw.domain.Bet;
import com.btsy.intw.service.BetProcessingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaBetConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaBetConsumerService.class);

    private final BetProcessingService betProcessingService;
    private final ObjectMapper objectMapper;

    public KafkaBetConsumerService(BetProcessingService betProcessingService) {
        this.betProcessingService = betProcessingService;
        this.objectMapper = new ObjectMapper();
    }

    @KafkaListener(topics = "${spring.kafka.template.default-topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeBet(String message) {
        try {
            Bet bet = objectMapper.readValue(message, Bet.class);
            betProcessingService.processBet(bet);
        } catch (Exception e) {
            logger.error("Error deserializing bet: {}, {}", message, e.getMessage(), e);
        }
    }
}