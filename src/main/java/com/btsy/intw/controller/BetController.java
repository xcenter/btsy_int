package com.btsy.intw.controller;

import com.btsy.intw.domain.Bet;
import com.btsy.intw.service.BetSubmissionService;
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

    private final BetSubmissionService betSubmissionService;

    @Autowired
    public BetController(BetSubmissionService betSubmissionService) {
        this.betSubmissionService = betSubmissionService;
    }

    @PutMapping("/place")
    public ResponseEntity<String> placeBet(@Valid @RequestBody @Parameter(description = "Bet submission") final Bet bet) {
        betSubmissionService.placeBet(bet);
        return ResponseEntity.ok("Bet submitted for user: " + bet.getUserId());
    }


}
