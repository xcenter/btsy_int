package com.btsy.intw.service.calculator;

import com.btsy.intw.repository.entity.JackpotEntity;
import com.btsy.intw.service.calculator.function.WinFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WinFunctionStrategy {

    private final Map<String, WinFunction> functionMap = new HashMap<>();

    private static final Logger logger = LoggerFactory.getLogger(WinFunctionStrategy.class);

    public void registerFunction(String key, WinFunction function) {
        if (functionMap.containsKey(key)) {
            throw new IllegalArgumentException("Win chance function with key " + key + " is already registered.");
        }

        functionMap.put(key, function);
    }

    public Boolean isJackpotWin(JackpotEntity jackpot) {
        WinFunction function = functionMap.get(jackpot.getWinFunctionName());

        if (function == null) {
            throw new IllegalArgumentException("No WinFunction found for key: " + jackpot.getWinFunctionName());
        }

        logger.info("Calculating win chance for jackpot with ID: {} with function: {}", jackpot.getId(), jackpot.getWinFunctionName());

        Double winChance = function.calculateWinChance(jackpot);
        double randomValue = Math.random();

        logger.info("Random value generated: {}. Win chance: {}", randomValue, winChance);

        return randomValue <= winChance;
    }
}
