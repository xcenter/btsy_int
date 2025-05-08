package com.btsy.intw.service.functions;

import com.btsy.intw.repository.entity.JackpotEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WinFunctionStrategy {

    private final Map<String, WinFunction> functionMap = new HashMap<>();

    public void registerFunction(String key, WinFunction function) {
        functionMap.put(key, function);
    }

    public Integer calculateWinChance(JackpotEntity jackpot) {
        WinFunction function = functionMap.get(jackpot.getWinConfig().getFunctionName());

        if (function == null) {
            throw new IllegalArgumentException("No ContributionFunction found for key: " + jackpot.getContributionConfig().getFunctionName());
        }

        return function.calculateWinChance(jackpot);
    }
}
