package com.btsy.intw.service.functions;

import com.btsy.intw.repository.entity.JackpotEntity;

public class FixedWinChanceFunction implements WinFunction {

    @Override
    public Integer calculateWinChance(JackpotEntity jackpot) {
        return jackpot.getWinConfig().getFixedRate();
    }
}
