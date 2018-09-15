package com.appium.serenirybdd.error_hanlders;

/**
 * Use for all exception related to Business
 */
public class BusinessException extends RuntimeException {
    public BusinessException(String errorMessage){super(errorMessage);}
}
