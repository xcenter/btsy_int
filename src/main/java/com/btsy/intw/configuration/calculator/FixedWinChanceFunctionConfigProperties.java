package com.btsy.intw.configuration.calculator;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties(prefix = "application.win-chance.fixed")
@Configuration
public class FixedWinChanceFunctionConfigProperties {

    @Name("chance")
    private double winChance;
}