package com.appium.serenirybdd.serenity;

import com.appium.serenirybdd.pages.NewCustomerPage;
import com.appium.serenirybdd.pages.NewCustomerSuccessPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class NewCustomerSteps extends ScenarioSteps {
    private static final long serialVersionUID = 1L;

    NewCustomerPage newCustomerPage;

    NewCustomerSuccessPage newCustomerSuccessPage;

    @Step
    public void createNewCustomer(){
        newCustomerPage.fillForValidUser();
    }

    @Step
    public void verifyCreatedCustomer(){
        newCustomerSuccessPage.verify();
    }
}
