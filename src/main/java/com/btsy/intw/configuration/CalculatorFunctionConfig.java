package com.btsy.intw.configuration;

import com.btsy.intw.service.calculator.ContributionFunctionStrategy;
import com.btsy.intw.service.calculator.WinFunctionStrategy;
import com.btsy.intw.service.calculator.function.FixedContributionFunction;
import com.btsy.intw.service.calculator.function.FixedWinChanceFunction;
import com.btsy.intw.service.calculator.function.LinearContributionFunction;
import com.btsy.intw.service.calculator.function.LinearWinChanceFunction;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculatorFunctionConfig {
    private final ContributionFunctionStrategy contributionFunctionStrategy;
    private final WinFunctionStrategy winFunctionStrategy;
    private final WinChanceConfigProperties winChanceConfigProperties;
    private final ContributionConfigProperties contributionConfigProperties;

    @Autowired
    public CalculatorFunctionConfig(
            ContributionFunctionStrategy contributionFunctionStrategy,
            WinFunctionStrategy winFunctionStrategy,
            WinChanceConfigProperties winChanceConfigProperties,
            ContributionConfigProperties contributionConfigProperties) {
        this.contributionFunctionStrategy = contributionFunctionStrategy;
        this.winFunctionStrategy = winFunctionStrategy;
        this.winChanceConfigProperties = winChanceConfigProperties;
        this.contributionConfigProperties = contributionConfigProperties;
    }


    @PostConstruct
    public void registerContributionFunctions() {
        contributionFunctionStrategy.registerFunction("LinearContribution", new LinearContributionFunction(contributionConfigProperties.getLinearContributionFunctionConfigProperties()));
        contributionFunctionStrategy.registerFunction("FixedContribution", new FixedContributionFunction(contributionConfigProperties.getFixedContributionFunctionConfigProperties()));
    }

    @PostConstruct
    public void registerWinFunctions() {
        winFunctionStrategy.registerFunction("LinearWinChance", new LinearWinChanceFunction(winChanceConfigProperties.getLinearWinChanceFunctionConfigProperties()));
        winFunctionStrategy.registerFunction("FixedWinChance", new FixedWinChanceFunction(winChanceConfigProperties.getFixedWinChanceFunctionConfigProperties()));
    }
}
