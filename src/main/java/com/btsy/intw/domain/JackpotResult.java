package com.btsy.intw.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JackpotResult {

    @Schema(description = "Id of the winning bet")
    @JsonProperty
    private String betId;

    @Schema(description = "Id of the winner")
    @JsonProperty
    private String userId;

    @Schema(description = "Amount of jackpot")
    @JsonProperty
    private double jackpotAmount;

    @Schema(description = "Creation time of the jackpot")
    @JsonProperty
    private String createdAt;

}
