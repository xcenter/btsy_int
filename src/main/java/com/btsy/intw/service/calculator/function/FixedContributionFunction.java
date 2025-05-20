package com.btsy.intw.service.calculator.function;

import com.btsy.intw.configuration.calculator.FixedContributionFunctionConfigProperties;
import com.btsy.intw.repository.entity.JackpotEntity;

public class FixedContributionFunction implements ContributionFunction {

    private final FixedContributionFunctionConfigProperties configProperties;

    public FixedContributionFunction (FixedContributionFunctionConfigProperties configProperties) {
        this.configProperties = configProperties;
    }

    @Override
    public Double calculateContribution(JackpotEntity jackpot, Double betAmount) {
        return configProperties.getContribution() * betAmount;
    }
}
