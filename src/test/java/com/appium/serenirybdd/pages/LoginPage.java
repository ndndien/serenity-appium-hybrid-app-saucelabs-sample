package com.appium.serenirybdd.pages;

import com.appium.serenirybdd.configs.MyConfigs;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private static final String LOCATOR_INPUT_USER_TEXT_FIELD = "//input[@name='uid']";
    private static final String LOCATOR_INPUT_PW_TEXT_FIELD = "//input[@name='password']";
    private static final String LOCATOR_LOGIN_BUTTON = "//input[@name='btnLogin']";

    @FindBy(xpath = LOCATOR_INPUT_USER_TEXT_FIELD)
    private WebElement inputUserTextField;

    @FindBy(xpath = LOCATOR_INPUT_PW_TEXT_FIELD)
    private WebElement inputPasswordTextField;

    @FindBy(xpath = LOCATOR_LOGIN_BUTTON)
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private void openSite(){
        getDriver().get(MyConfigs.WEBSITE);
    }

    public void loginToSystem(String userId, String password){
        openSite();
        waitForMainElementVisible();
        inputUserTextField.sendKeys(userId);
        inputPasswordTextField.sendKeys(password);
        submit();
    }

    @Override
    public void waitForMainElementVisible() {
        waitForVisibility(inputUserTextField);
        waitForVisibility(inputPasswordTextField);
        waitForVisibility(loginButton);
    }

    @Override
    public void submit() {
        clickOn(loginButton);
    }


    @Override
    public void verify() {
        // implement if needed
    }
}
