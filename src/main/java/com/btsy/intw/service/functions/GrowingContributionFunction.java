package com.btsy.intw.service.functions;

import com.btsy.intw.repository.entity.JackpotEntity;

/**
 * The `GrowingContributionFunction` class implements the `ContributionFunction` interface
 * and provides a method to calculate the contribution percentage of a player to the jackpot.
 *
 * <p>The contribution percentage is determined based on the current jackpot pool size
 * relative to the minimum and maximum pool values. The calculation follows these rules:
 * <ul>
 *   <li>If the pool is less than or equal to the minimum pool, the contribution is 5%.</li>
 *   <li>If the pool is greater than or equal to the maximum pool, the contribution is 90%.</li>
 *   <li>For pool values between the minimum and maximum, the contribution is calculated
 *       using linear interpolation between 5% and 90%.</li>
 * </ul>
 *
 * <p>This ensures that the contribution percentage grows linearly as the pool size increases.
 */
public class GrowingContributionFunction implements ContributionFunction {

    /**
     * Calculates the contribution percentage of a player to the jackpot based on the current pool size.
     *
     * @param jackpotEntity The `JackpotEntity` object containing the current pool, minimum pool, and maximum pool values.
     * @return The contribution percentage as an integer value between 5 and 90.
     */
    public Integer calculatePercentage(JackpotEntity jackpotEntity) {
        int pool = jackpotEntity.getPool();
        int minPool = jackpotEntity.getMinPool();
        int maxPool = jackpotEntity.getMaxPool();

        if (pool <= minPool) {
            return 5; // 5% contribution at min pool
        } else if (pool >= maxPool) {
            return 90; // 90% contribution at max pool
        } else {
            // Linear interpolation between 5% and 90%
            return 5 + (85 * (pool - minPool) / (maxPool - minPool));
        }
    }
}
