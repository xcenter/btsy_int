package com.btsy.intw.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    @Schema(description = "Id of the user")
    @JsonProperty
    private String id;

    @Schema(description = "Name of the user")
    @JsonProperty
    private String name;
}
