package com.btsy.intw.controller;

import com.btsy.intw.domain.BetSubmission;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bet")
public class BetController {

    @PutMapping("/placeBet")
    public ResponseEntity<String> placeBet(@Valid @RequestBody @Parameter(description = "Bet submission") final BetSubmission submission) {
        return ResponseEntity.ok("Bet placed successfully for user: " + submission.toString());
    }


}
