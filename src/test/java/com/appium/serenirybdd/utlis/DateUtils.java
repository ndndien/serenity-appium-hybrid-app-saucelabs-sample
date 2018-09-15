package com.appium.serenirybdd.utlis;

import java.time.LocalDate;

/**
 * Utils or Date and Time
 */
public class DateUtils {

    private DateUtils(){
        // do nothing
    }

    public static String getCurrentDate(){
        return LocalDate.now().toString();
    }
}
