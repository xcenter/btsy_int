package com.btsy.intw.service.functions;

import com.btsy.intw.repository.entity.JackpotEntity;

public interface WinFunction {

    public Integer calculateWinChance(JackpotEntity jackpot);
}
