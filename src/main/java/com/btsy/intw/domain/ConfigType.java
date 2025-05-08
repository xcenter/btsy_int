package com.btsy.intw.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

enum ConfigType {
    FIXED("fixed"),
    VARIABLE("variable");

    public final String value;

    ConfigType(String value) {
        this.value = value;
    }

    @JsonProperty
    public String getValue() {
        return value;
    }
}
