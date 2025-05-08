package com.btsy.intw.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

@Data
@Builder
public class Jackpot {

    @Schema(description = "Id of the jackpot")
    @JsonProperty
    private String id;

    @Schema(description = "Current pool of the jackpot")
    @JsonProperty
    private BigInteger pool;

    @Schema(description = "Contribution config")
    @JsonProperty
    private ContributionConfig contributionConfig;

    @Schema(description = "Win config")
    @JsonProperty
    private WinConfig winConfig;
}
