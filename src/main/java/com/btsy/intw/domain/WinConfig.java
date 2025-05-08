package com.btsy.intw.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonDeserialize(builder = WinConfig.WinConfigBuilder.class)
public class WinConfig {

    @Schema(description = "Id of the win config")
    @JsonProperty
    private Integer id;

    @Schema(description = "Variable function of win")
    @JsonProperty
    private String functionName;

    @Schema(description = "Fixed rate of win")
    @JsonProperty
    private Integer fixedRate;
}
