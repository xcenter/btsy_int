package com.btsy.intw.service.functions;

import com.btsy.intw.repository.entity.JackpotEntity;

public class FixedContributionFunction implements ContributionFunction {
    @Override
    public Integer calculatePercentage(JackpotEntity jackpot) {
        return jackpot.getContributionConfig().getFixedRate();
    }
}
