package com.btsy.intw.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContributionConfig {
    @Schema(description = "Id of the contribution config")
    @JsonProperty
    private String id;

    @Schema(description = "Contribution type")
    @JsonProperty
    private ConfigType configType;

    @Schema(description = "Variable function of contribution")
    @JsonProperty
    private String variableFunction;

    @Schema(description = "Fixed percentage of contribution")
    @JsonProperty
    private Integer fixedValue;
}
