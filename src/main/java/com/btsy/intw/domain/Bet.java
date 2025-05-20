package com.btsy.intw.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonDeserialize(builder = Bet.BetBuilder.class)
public class Bet {

    @Schema(description = "Unique identifier for the bet")
    @JsonProperty
    private Integer betId;

    @Schema(description = "Unique identifier for the user placing the bet")
    @NotNull(message = "User ID cannot be blank")
    @JsonProperty
    private Integer userId;

    @Schema(description = "Unique identifier for the jackpot associated with the bet")
    @NotNull(message = "Jackpot ID cannot be blank")
    @JsonProperty
    private Integer jackpotId;

    @Schema(description = "Amount of money being bet")
    @Min(value = 1, message = "Bet amount must be at least 1")
    @JsonProperty
    private Double amount;
}
