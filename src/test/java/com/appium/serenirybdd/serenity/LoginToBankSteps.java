package com.appium.serenirybdd.serenity;

import com.appium.serenirybdd.configs.MyConfigs;
import com.appium.serenirybdd.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class LoginToBankSteps extends ScenarioSteps {

    private static final long serialVersionUID = 1L;

    LoginPage loginPage;

    @Step
    public void loginToSystem(){
        loginPage.loginToSystem(MyConfigs.SYSTEM_USER_NAME, MyConfigs.SYSTEM_USER_PASSWORD);
    }
}
