package com.btsy.intw.controller;

import com.btsy.intw.domain.Bet;
import com.btsy.intw.service.kafka.KafkaProducerService;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bet")
public class BetController {

    private final KafkaProducerService kafkaProducerService;

    @Autowired
    public BetController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PutMapping("/place")
    public ResponseEntity<String> placeBet(@Valid @RequestBody @Parameter(description = "Bet submission") final Bet submission) {
        kafkaProducerService.sendMessage(submission.toString());
        return ResponseEntity.ok("Bet placed successfully for user: " + submission);
    }


}
