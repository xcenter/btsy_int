package com.btsy.intw.configuration;

import com.btsy.intw.configuration.calculator.FixedWinChanceFunctionConfigProperties;
import com.btsy.intw.configuration.calculator.LinearWinChanceFunctionConfigProperties;
import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class WinChanceConfigProperties {

    private final FixedWinChanceFunctionConfigProperties fixedWinChanceFunctionConfigProperties;
    private final LinearWinChanceFunctionConfigProperties linearWinChanceFunctionConfigProperties;

    public WinChanceConfigProperties(
            FixedWinChanceFunctionConfigProperties fixedWinChanceFunctionConfigProperties,
            LinearWinChanceFunctionConfigProperties linearWinChanceFunctionConfigProperties) {
        this.fixedWinChanceFunctionConfigProperties = fixedWinChanceFunctionConfigProperties;
        this.linearWinChanceFunctionConfigProperties = linearWinChanceFunctionConfigProperties;
    }

}
