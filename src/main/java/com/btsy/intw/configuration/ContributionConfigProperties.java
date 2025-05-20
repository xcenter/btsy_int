package com.btsy.intw.configuration;

import com.btsy.intw.configuration.calculator.FixedContributionFunctionConfigProperties;
import com.btsy.intw.configuration.calculator.LinearContributionFunctionConfigProperties;
import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class ContributionConfigProperties {

    private final LinearContributionFunctionConfigProperties linearContributionFunctionConfigProperties;
    private final FixedContributionFunctionConfigProperties fixedContributionFunctionConfigProperties;
    public ContributionConfigProperties(
            LinearContributionFunctionConfigProperties linearContributionFunctionConfigProperties,
            FixedContributionFunctionConfigProperties fixedContributionFunctionConfigProperties) {
        this.linearContributionFunctionConfigProperties = linearContributionFunctionConfigProperties;
        this.fixedContributionFunctionConfigProperties = fixedContributionFunctionConfigProperties;
    }
}
