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
@JsonDeserialize(builder = User.UserBuilder.class)
public class User {

    @Schema(description = "Id of the user")
    @JsonProperty
    private Integer id;

    @Schema(description = "Name of the user")
    @JsonProperty
    private String name;
}
