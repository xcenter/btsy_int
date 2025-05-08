package com.btsy.intw.service;

import com.btsy.intw.domain.Bet;
import com.btsy.intw.exception.BetPlacementException;
import com.btsy.intw.service.kafka.KafkaBetProducerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BetSubmissionService {


    private static final Logger logger = LoggerFactory.getLogger(BetSubmissionService.class);

    private final KafkaBetProducerService kafkaBetProducerService;

    @Autowired
    public BetSubmissionService(KafkaBetProducerService kafkaBetProducerService) {
        this.kafkaBetProducerService = kafkaBetProducerService;
    }

    public void placeBet(Bet bet) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String betJson = objectMapper.writeValueAsString(bet);
            kafkaBetProducerService.publishBet(betJson);
        } catch (Exception e) {
            logger.error("Error serializing bet: {}, {}", bet, e.getMessage());
            throw new BetPlacementException("Failed to place bet");
        }
    }
}
