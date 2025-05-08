package com.btsy.intw.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WinConfig {

    @Schema(description = "Id of the win config")
    @JsonProperty
    private String id;

    @Schema(description = "Win type")
    @JsonProperty
    private ConfigType configType;

    @Schema(description = "Variable function of win")
    @JsonProperty
    private String variableFunction;

    @Schema(description = "Fixed percentage of win")
    @JsonProperty
    private Integer fixedValue;
}
