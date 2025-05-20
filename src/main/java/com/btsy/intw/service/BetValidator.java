package com.btsy.intw.service;

import com.btsy.intw.domain.Bet;
import com.btsy.intw.repository.JackpotRepository;
import com.btsy.intw.repository.UserRepository;
import com.btsy.intw.repository.entity.JackpotEntity;
import com.btsy.intw.service.kafka.KafkaBetProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BetValidator {

    private final UserRepository userRepository;
    private final JackpotRepository jackpotRepository;
    private final KafkaBetProducerService kafkaBetProducerService;

    @Autowired
    public BetValidator(UserRepository userRepository, JackpotRepository jackpotRepository, KafkaBetProducerService kafkaBetProducerService) {
        this.userRepository = userRepository;
        this.jackpotRepository = jackpotRepository;
        this.kafkaBetProducerService = kafkaBetProducerService;
    }

    public JackpotEntity validJacpotForBet(Bet bet) {
        try {
            validateUserId(bet.getUserId());
            return validJackpot(bet.getJackpotId());
        } catch (IllegalArgumentException e) {
            kafkaBetProducerService.publishBetToDlq(bet.toString());
            throw new IllegalArgumentException(e.getMessage());
        }
    }
    private void validateUserId(Integer userId) {
        if (!userRepository.existsById(userId)) {
            throw new IllegalArgumentException("User not found for ID: " + userId);
        }
    }

    private JackpotEntity validJackpot(Integer jackpotId) {
        return jackpotRepository.findById(jackpotId)
                .orElseThrow(() -> new IllegalArgumentException("Jackpot not found for ID: " + jackpotId));
    }
}
