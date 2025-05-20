package com.btsy.intw.service.calculator;

import com.btsy.intw.repository.entity.JackpotEntity;
import com.btsy.intw.service.calculator.function.ContributionFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ContributionFunctionStrategy {

    private final Map<String, ContributionFunction> functionMap = new HashMap<>();

    public void registerFunction(String key, ContributionFunction function) {
        if (functionMap.containsKey(key)) {
            throw new IllegalArgumentException("Contribution config function with key " + key + " is already registered.");
        }
        functionMap.put(key, function);
    }

    public Double calculateContribution(JackpotEntity jackpot, Double betAmount) {
        ContributionFunction function = functionMap.get(jackpot.getContributionFunctionName());

        if (function == null) {
            throw new IllegalArgumentException("No ContributionFunction found for key: " + jackpot.getContributionFunctionName());
        }

        return function.calculateContribution(jackpot, betAmount);
    }
}
