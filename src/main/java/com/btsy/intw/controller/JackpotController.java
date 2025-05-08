package com.btsy.intw.controller;

import com.btsy.intw.domain.JackpotResult;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jackpot")
public class JackpotController {

    @GetMapping("/evaluateJackpot/{jackpotId}")
    public ResponseEntity<JackpotResult> evaluateJackpot(@NotEmpty @PathVariable("jackpotId") @Parameter(description = "Id of the jackpot to evaluate") final String jackpotId) {
        return ResponseEntity.ok(JackpotResult.builder().build());
    }

    @GetMapping("/listJackpotIds")
    public ResponseEntity<List<String>> listJackpots() {
        return ResponseEntity.ok(List.of("123", "456", "789"));
    }
}


