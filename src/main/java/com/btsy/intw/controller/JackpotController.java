package com.btsy.intw.controller;

import com.btsy.intw.domain.Jackpot;
import com.btsy.intw.domain.JackpotWin;
import com.btsy.intw.service.JackpotService;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jackpot")
public class JackpotController {

    private final JackpotService jackpotService;

    @Autowired
    public JackpotController(JackpotService jackpotService) {
        this.jackpotService = jackpotService;
    }

    @GetMapping("/evaluate/{betId}")
    public ResponseEntity<JackpotWin> evaluateJackpot(@NotEmpty @PathVariable("betId") @Parameter(description = "Id of bet to evaluate") final String jackpotId) {
        return ResponseEntity.ok(JackpotWin.builder().build());
    }

    @GetMapping("/list")
    public ResponseEntity<List<Jackpot>> listJackpots() {
        return ResponseEntity.ok(jackpotService.getJackpots());
    }
}


