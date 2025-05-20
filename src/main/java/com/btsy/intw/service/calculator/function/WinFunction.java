package com.btsy.intw.service.calculator.function;

import com.btsy.intw.repository.entity.JackpotEntity;

public interface WinFunction {

    public Double calculateWinChance(JackpotEntity jackpot);
}
