package com.btsy.intw.service.calculator.function;

import com.btsy.intw.repository.entity.JackpotEntity;

public interface ContributionFunction {

    public Double calculateContribution(JackpotEntity jackpotEntity, Double betAmount);
}
