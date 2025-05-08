package com.btsy.intw.service.functions;

import com.btsy.intw.repository.entity.JackpotEntity;

public interface ContributionFunction {

    public Integer calculatePercentage(JackpotEntity jackpotEntity);
}
