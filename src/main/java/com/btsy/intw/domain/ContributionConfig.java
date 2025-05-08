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
@JsonDeserialize(builder = ContributionConfig.ContributionConfigBuilder.class)
public class ContributionConfig {
    @Schema(description = "Id of the contribution config")
    @JsonProperty
    private Integer id;

    @Schema(description = "Variable function of contribution")
    @JsonProperty
    private String functionName;

    @Schema(description = "Fixed rate of contribution")
    @JsonProperty
    private Integer fixedRate;
}
