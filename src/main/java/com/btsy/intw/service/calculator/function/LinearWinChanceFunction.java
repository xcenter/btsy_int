package com.btsy.intw.service.calculator.function;

import com.btsy.intw.configuration.calculator.LinearWinChanceFunctionConfigProperties;
import com.btsy.intw.repository.entity.JackpotEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinearWinChanceFunction implements WinFunction {

    private final LinearWinChanceFunctionConfigProperties configProperties;

    private static final Logger logger = LoggerFactory.getLogger(LinearWinChanceFunction.class);


    public LinearWinChanceFunction(LinearWinChanceFunctionConfigProperties configProperties) {
        this.configProperties = configProperties;
    }

    @Override
    public Double calculateWinChance(JackpotEntity jackpot) {
        double pool = jackpot.getPool();
        double minPool = jackpot.getMinPool();
        double maxPool = jackpot.getMaxPool();

        double minWinChance = configProperties.getMinimumWinChance();

        double winChance;

        if (pool <= minPool) {
            winChance = minWinChance;
        } else if (pool >= maxPool) {
            winChance = 1.0;
        } else {
            double ratio = (pool - minPool) / (maxPool - minPool);
            winChance = minWinChance + (1.0 - minWinChance) * ratio;
        }
        logger.info("Win chance for jackpot with ID: {} with min pool: {}, max pool: {} and mim win chance: {} is {}",
                jackpot.getId(), minPool, maxPool, minWinChance, winChance);
        return winChance;
    }
}