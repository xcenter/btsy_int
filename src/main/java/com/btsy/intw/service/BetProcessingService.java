package com.btsy.intw.service;

import com.btsy.intw.domain.Bet;
import com.btsy.intw.repository.BetRepository;
import com.btsy.intw.repository.JackpotRepository;
import com.btsy.intw.repository.JackpotWinRepository;
import com.btsy.intw.repository.entity.BetEntity;
import com.btsy.intw.repository.entity.JackpotEntity;
import com.btsy.intw.repository.entity.JackpotWinEntity;
import com.btsy.intw.service.calculator.ContributionFunctionStrategy;
import com.btsy.intw.service.calculator.WinFunctionStrategy;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BetProcessingService {

    private static final Logger logger = LoggerFactory.getLogger(BetProcessingService.class);

    private final ContributionFunctionStrategy contributionFunctionStrategy;
    private final WinFunctionStrategy winFunctionStrategy;
    private final JackpotRepository jackpotRepository;
    private final BetRepository betRepository;
    private final BetValidator betValidator;
    private final JackpotWinRepository jackpotWinRepository;

    @Autowired
    public BetProcessingService(
            ContributionFunctionStrategy contributionFunctionStrategy,
            JackpotRepository jackpotRepository,
            BetRepository betRepository,
            BetValidator betValidator,
            WinFunctionStrategy winFunctionStrategy,
            JackpotWinRepository jackpotWinRepository) {
        this.contributionFunctionStrategy = contributionFunctionStrategy;
        this.jackpotRepository = jackpotRepository;
        this.betRepository = betRepository;
        this.betValidator = betValidator;
        this.winFunctionStrategy = winFunctionStrategy;
        this.jackpotWinRepository = jackpotWinRepository;
    }

    @Transactional
    public void processBet(Bet bet) {
        JackpotEntity jackpot = betValidator.validJacpotForBet(bet);

        int betId = saveBet(bet, jackpot);
        double contribution = calculateContribution(bet.getAmount(), jackpot);
        updateJackpotPool(jackpot, jackpot.getPool() + contribution);

        if (winFunctionStrategy.isJackpotWin(jackpot)) {
            handleJackpotWin(bet, jackpot);
        }
        jackpotRepository.save(jackpot);
        logger.info("Bet with id: {} processed for user {}. Contribution added to jackpot pool: {}", betId, bet.getUserId(), contribution);
    }

    private Integer saveBet(Bet bet, JackpotEntity jackpot) {
        return betRepository.save(BetEntity.builder().userId(bet.getUserId()).betAmount(bet.getAmount()).jackpotId(jackpot.getId()).build()).getId();
    }

    private void handleJackpotWin(Bet bet, JackpotEntity jackpot) {
        Double winningAmount = jackpot.getPool();
        JackpotWinEntity win = JackpotWinEntity.builder()
                .betId(bet.getBetId())
                .jackpotId(jackpot.getId())
                .winAmount(winningAmount)
                .userId(bet.getUserId())
                .build();
        jackpotWinRepository.save(win);
        updateJackpotPool(jackpot, jackpot.getMinPool());
        logger.info("User {} won the jackpot with bet ID {}. Winning amount: {}", bet.getUserId(), bet.getBetId(), winningAmount);
    }

    private void updateJackpotPool(JackpotEntity jackpot, double jackpot1) {
        jackpot.setPool(jackpot1);
        logger.info("Current jackpot pool for ID {}: {}", jackpot.getId(), jackpot.getPool());
    }

    private Double calculateContribution(Double betAmount, JackpotEntity jackpot) {
        return contributionFunctionStrategy.calculateContribution(jackpot, betAmount);
    }
}
