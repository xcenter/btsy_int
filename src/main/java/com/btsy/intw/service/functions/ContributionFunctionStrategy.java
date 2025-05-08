package com.btsy.intw.service.functions;

import com.btsy.intw.repository.entity.JackpotEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ContributionFunctionStrategy {

    private final Map<String, ContributionFunction> functionMap = new HashMap<>();

    public void registerFunction(String key, ContributionFunction function) {
        functionMap.put(key, function);
    }

    public Integer calculateContribution(JackpotEntity jackpot) {
        ContributionFunction function = functionMap.get(jackpot.getContributionConfig().getFunctionName());

        if (function == null) {
            throw new IllegalArgumentException("No ContributionFunction found for key: " + jackpot.getContributionConfig().getFunctionName());
        }

        return function.calculatePercentage(jackpot);
    }
}
