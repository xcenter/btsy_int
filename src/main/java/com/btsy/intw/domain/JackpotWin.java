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
@JsonDeserialize(builder = JackpotWin.JackpotWinBuilder.class)
public class JackpotWin {

    @Schema(description = "Id of the winning bet")
    @JsonProperty
    private Integer betId;

    @Schema(description = "Id of the winner")
    @JsonProperty
    private Integer userId;

    @Schema(description = "Amount of jackpot")
    @JsonProperty
    private Double jackpotAmount;

    @Schema(description = "Creation time of the jackpot")
    @JsonProperty
    private String createdAt;

}
