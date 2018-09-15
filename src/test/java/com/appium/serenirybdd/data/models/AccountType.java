package com.appium.serenirybdd.data.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum AccountType {

    @JsonProperty("Current") CURRENT_ACCOUNT("Current"),
    @JsonProperty("Savings") SAVINGS_ACCOUNT("Savings");

    private final String type;

    AccountType(String accountType){
        this.type = accountType;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
