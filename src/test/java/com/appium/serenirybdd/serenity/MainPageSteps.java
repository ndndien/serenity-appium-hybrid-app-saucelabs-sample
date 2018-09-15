package com.appium.serenirybdd.serenity;

import com.appium.serenirybdd.pages.MainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class MainPageSteps extends ScenarioSteps {

    private static final long serialVersionUID = 1L;

    MainPage mainPage;

    @Step
    public void openNewCustomerTab(){
        mainPage.openNewCustomerTab();
    }

    @Step
    public void openNewAccountTab(){
        mainPage.openNewAccountTab();
    }

    @Step
    public void openDepositTab(){
        mainPage.openDepositTab();
    }
}
