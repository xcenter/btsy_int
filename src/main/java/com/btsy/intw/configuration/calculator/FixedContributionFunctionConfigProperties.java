package com.btsy.intw.configuration.calculator;


import jdk.jfr.Name;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties(prefix = "application.contribution.fixed")
@Configuration
public class FixedContributionFunctionConfigProperties {

    @Name("contribution")
    private double contribution;
}
