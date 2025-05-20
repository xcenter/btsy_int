package com.btsy.intw.service.calculator.function;

import com.btsy.intw.configuration.calculator.FixedWinChanceFunctionConfigProperties;
import com.btsy.intw.repository.entity.JackpotEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FixedWinChanceFunction implements WinFunction {

    private final FixedWinChanceFunctionConfigProperties configProperties;

    private static final Logger logger = LoggerFactory.getLogger(FixedWinChanceFunction.class);

    public FixedWinChanceFunction(FixedWinChanceFunctionConfigProperties configProperties) {
        this.configProperties = configProperties;
    }

    @Override
    public Double calculateWinChance(JackpotEntity jackpot) {

        logger.info("Win chance for jackpot with ID: {} with function: {}", jackpot.getId(), configProperties.getWinChance());
        return configProperties.getWinChance();
    }
}
