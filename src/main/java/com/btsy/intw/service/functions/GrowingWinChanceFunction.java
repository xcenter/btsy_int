package com.btsy.intw.service.functions;

import com.btsy.intw.repository.entity.JackpotEntity;

/**
 * The `GrowingWinChanceFunction` class implements the `WinFunction` interface
 * and provides a method to calculate the win chance based on the jackpot pool size.
 *
 * <p>The win chance is determined based on the current jackpot pool size
 * relative to the minimum and maximum pool values. The calculation follows these rules:
 * <ul>
 *   <li>If the pool is less than or equal to the minimum pool, the win chance is 0%</li>
 *   <li>If the pool is greater than or equal to the maximum pool, the win chance is 100%</li>
 *   <li>For pool values between the minimum and maximum, the win chance is calculated
 *       using linear interpolation between 0 and 100</li>
 * </ul>
 *
 * <p>This ensures that the win chance grows linearly as the pool size increases.
 */
public class GrowingWinChanceFunction implements WinFunction {

    /**
     * Calculates the win chance based on the jackpot pool.
     *
     * @param jackpot The jackpot entity containing pool information.
     * @return The calculated win chance as an integer value (0 to 100).
     */
    @Override
    public Integer calculateWinChance(JackpotEntity jackpot) {
        int pool = jackpot.getPool();
        int minPool = jackpot.getMinPool();
        int maxPool = jackpot.getMaxPool();

        if (pool <= minPool) {
            return 0;
        } else if (pool >= maxPool) {
            return 100;
        } else {
            // Linear interpolation between 0% and 100%
            return (100 * (pool - minPool)) / (maxPool - minPool);
        }
    }
}