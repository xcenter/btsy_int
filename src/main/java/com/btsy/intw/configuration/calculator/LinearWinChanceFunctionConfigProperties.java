package com.btsy.intw.configuration.calculator;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties(prefix = "application.win-chance.linear")
@Configuration
public class LinearWinChanceFunctionConfigProperties {

    @Name("minimum-win-chance")
    private double minimumWinChance;
}
