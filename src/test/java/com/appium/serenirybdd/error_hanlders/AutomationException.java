package com.appium.serenirybdd.error_hanlders;

/**
 * Use for all exception related to Automation
 */
public class AutomationException extends RuntimeException{
    public AutomationException(String errorMessage){super(errorMessage);}
}
