package com.btsy.intw.service.calculator.function;

import com.btsy.intw.configuration.calculator.LinearContributionFunctionConfigProperties;
import com.btsy.intw.repository.entity.JackpotEntity;

public class LinearContributionFunction implements ContributionFunction {

    private final LinearContributionFunctionConfigProperties configProperties;

    public LinearContributionFunction(LinearContributionFunctionConfigProperties configProperties) {
        this.configProperties = configProperties;
    }

    public Double calculateContribution(JackpotEntity jackpotEntity, Double betAmount) {
        double pool = jackpotEntity.getPool();
        double minPool = jackpotEntity.getMinPool();
        double maxPool = jackpotEntity.getMaxPool();

        double minContribution = configProperties.getMinimumContribution();
        double maxContribution = configProperties.getMaximumContribution();

        if (pool <= minPool) {
            return minContribution;
        } else if (pool >= maxPool) {
            return maxContribution;
        } else {
            double ratio = (pool - minPool) / (maxPool - minPool);
            return minContribution + (maxContribution - minContribution) * ratio;
        }
    }
}
