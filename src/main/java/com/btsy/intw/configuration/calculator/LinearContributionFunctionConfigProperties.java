package com.btsy.intw.configuration.calculator;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties(prefix = "application.contribution.linear")
@Configuration
public class LinearContributionFunctionConfigProperties {

    @Name("minimum-contribution")
    private double minimumContribution;

    @Name("maximum-contribution")
    private double maximumContribution;
}
