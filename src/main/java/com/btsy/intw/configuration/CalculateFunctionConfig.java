package com.btsy.intw.configuration;

import com.btsy.intw.service.functions.*;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculateFunctionConfig {
    private final ContributionFunctionStrategy contributionFunctionStrategy;
    private final WinFunctionStrategy winFunctionStrategy;

    public CalculateFunctionConfig(ContributionFunctionStrategy contributionFunctionStrategy, WinFunctionStrategy winFunctionStrategy) {
        this.contributionFunctionStrategy = contributionFunctionStrategy;
        this.winFunctionStrategy = winFunctionStrategy;
    }

    @PostConstruct
    public void registerContributionFunctions() {
        contributionFunctionStrategy.registerFunction("GrowingContributionRateFunction", new GrowingContributionFunction());
        contributionFunctionStrategy.registerFunction("Fixed", new FixedContributionFunction());
    }

    @PostConstruct
    public void registerWinFunctions() {
        winFunctionStrategy.registerFunction("GrowingWinRateFunction", new GrowingWinChanceFunction());
        winFunctionStrategy.registerFunction("Fixed", new FixedWinChanceFunction());
    }
}
