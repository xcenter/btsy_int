package com.btsy.intw.service;

import com.btsy.intw.domain.Bet;
import com.btsy.intw.repository.BetRepository;
import com.btsy.intw.repository.JackpotRepository;
import com.btsy.intw.repository.JackpotWinRepository;
import com.btsy.intw.repository.entity.BetEntity;
import com.btsy.intw.repository.entity.JackpotEntity;
import com.btsy.intw.repository.entity.JackpotWinEntity;
import com.btsy.intw.service.functions.ContributionFunctionStrategy;
import com.btsy.intw.service.functions.WinFunctionStrategy;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        betValidator.validateBet(bet);

        Optional<JackpotEntity> jackpot = jackpotRepository.findById(bet.getJackpotId());

        if (jackpot.isPresent()) {
            jackpot.get().setPool(jackpot.get().getPool() + calculateContribution(bet.getAmount(), jackpot.get()));

            if(isWinningBet(jackpot.get())) {
                Integer winningAmount = jackpot.get().getPool();
                JackpotWinEntity win = JackpotWinEntity.builder().betId(bet.getBetId()).jackpotId(jackpot.get().getId()).winAmount(winningAmount).userId(bet.getUserId()).build();
                jackpotWinRepository.save(win);
                jackpot.get().setPool(jackpot.get().getMinPool());
                logger.info("User {} won the jackpot with bet ID {}. Winning amount: {}", bet.getUserId(), bet.getBetId(), winningAmount);
            }
            jackpotRepository.save(jackpot.get());
            betRepository.save(new BetEntity(bet.getBetId(), bet.getUserId(), bet.getJackpotId(), bet.getAmount()));
        } else {
            throw new IllegalArgumentException("Jackpot not found for ID: " + bet.getJackpotId());
        }
    }

    private Integer calculateContribution(Integer betAmount, JackpotEntity jackpot) {
        return betAmount * contributionFunctionStrategy.calculateContribution(jackpot);
    }

    private Boolean isWinningBet(JackpotEntity jackpot) {
        return Math.random() * 100 < winFunctionStrategy.calculateWinChance(jackpot);
    }
}
