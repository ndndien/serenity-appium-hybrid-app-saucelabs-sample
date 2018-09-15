package com.appium.serenirybdd.constants;

public enum  MyDriverContext {

    NATIVE_APP("NATIVE_APP"),
    CHROMIUM("CHROMIUM");

    private final String context;
    MyDriverContext(String context){
        this.context = context;
    }

    public String getContext(){
        return this.context;
    }
}
