package com.appium.serenirybdd.data.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Gender {

    @JsonProperty("male")
    MALE("male"),
    @JsonProperty("female")
    FEMALE("female");

    private final String userGender;

    Gender(String gender){
        this.userGender = gender;
    }

    @Override
    public String toString() {
        return this.userGender;
    }
}
