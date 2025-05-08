package com.btsy.intw.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BetSubmission {

    @NotBlank(message = "Bet ID cannot be blank")
    @Schema(description = "Unique identifier for the bet")
    @JsonProperty
    private String betId;

    @Schema(description = "Unique identifier for the user placing the bet")
    @NotBlank(message = "User ID cannot be blank")
    @JsonProperty
    private String userId;

    @Schema(description = "Unique identifier for the jackpot associated with the bet")
    @NotBlank(message = "Jackpot ID cannot be blank")
    @JsonProperty
    private String jackpotId;

    @Schema(description = "Amount of money being bet")
    @Min(value = 1, message = "Bet amount must be at least 1")
    @JsonProperty
    private Integer amount;
}
