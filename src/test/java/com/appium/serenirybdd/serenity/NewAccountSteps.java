package com.appium.serenirybdd.serenity;

import com.appium.serenirybdd.data.models.AccountType;
import com.appium.serenirybdd.pages.NewAccountPage;
import com.appium.serenirybdd.pages.NewAccountSuccessPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class NewAccountSteps extends ScenarioSteps {

    private static final long serialVersionUID = 1L;

    NewAccountPage newAccountPage;

    NewAccountSuccessPage newAccountSuccessPage;

    @Step
    public void createNewAccount(){
        newAccountPage.createNewAccount(AccountType.SAVINGS_ACCOUNT);
    }

    @Step
    public void verifyCreatedAccount(){
        newAccountSuccessPage.verify();
    }
}
