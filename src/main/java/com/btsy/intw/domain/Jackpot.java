package com.btsy.intw.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonDeserialize(builder = Jackpot.JackpotBuilder.class)
public class Jackpot {

    @Schema(description = "Id of the jackpot")
    @JsonProperty
    private Integer id;

    @Schema(description = "Current pool of the jackpot")
    @JsonProperty
    private Double pool;

    @Schema(description = "Contribution function")
    @JsonProperty
    private String contributionFunctionName;

    @Schema(description = "Win function")
    @JsonProperty
    private String winFunctionName;
}
