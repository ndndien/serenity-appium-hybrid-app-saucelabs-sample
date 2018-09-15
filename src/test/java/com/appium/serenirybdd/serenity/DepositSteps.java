package com.appium.serenirybdd.serenity;

import com.appium.serenirybdd.pages.DepositPage;
import com.appium.serenirybdd.pages.DepositSuccessPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class DepositSteps extends ScenarioSteps {

    private static final long serialVersionUID = 1L;

    DepositPage depositPage;

    DepositSuccessPage depositSuccessPage;

    @Step
    public void deposit(){
        depositPage.deposit(1234);
    }

    @Step
    public void verifyDeposit(){
        depositSuccessPage.verify();
    }
}
