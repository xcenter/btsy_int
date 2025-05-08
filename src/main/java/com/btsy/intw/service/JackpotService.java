package com.btsy.intw.service;

import com.btsy.intw.domain.ContributionConfig;
import com.btsy.intw.domain.Jackpot;
import com.btsy.intw.domain.WinConfig;
import com.btsy.intw.repository.JackpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JackpotService {

    private final JackpotRepository jackpotRepository;

    @Autowired
    public JackpotService(JackpotRepository jackpotRepository) {
        this.jackpotRepository = jackpotRepository;
    }

    public List<Jackpot> getJackpots() {
        return jackpotRepository.findAll().stream()
                .map(jackpotEntity -> Jackpot.builder()
                        .id(jackpotEntity.getId())
                        .pool(jackpotEntity.getPool())
                        .contributionConfig(
                                ContributionConfig.builder()
                                        .functionName(jackpotEntity.getContributionConfig().getFunctionName())
                                        .fixedRate(jackpotEntity.getContributionConfig().getFixedRate())
                                        .id(jackpotEntity.getContributionConfig().getId())
                                        .build()
                        )
                        .winConfig(
                                WinConfig.builder()
                                        .functionName(jackpotEntity.getWinConfig().getFunctionName())
                                        .fixedRate(jackpotEntity.getWinConfig().getFixedRate())
                                        .id(jackpotEntity.getWinConfig().getId())
                                        .build()
                        )
                        .build())
                .collect(Collectors.toList());
    }
}
