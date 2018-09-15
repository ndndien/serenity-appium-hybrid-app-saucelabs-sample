package com.appium.serenirybdd.pages;

import com.appium.serenirybdd.constants.MyDriverContext;
import com.appium.serenirybdd.data.models.Gender;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewCustomerPage extends BasePage {
    
    private static final String XPATH_INPUT_NAME = "//input[@name='name']";
    private static final String XPATH_RADIO_MALE = "//input[@value='m']";
    private static final String XPATH_RADIO_FEMALE = "//input[@value='f']";
    private static final String ID_SELECT_DOB = "dob";
    private static final String XPATH_INPUT_ADDRESS = "//textarea[@name='addr']";
    private static final String XPATH_INPUT_CITY = "//input[@name='city']";
    private static final String XPATH_INPUT_STATE = "//input[@name='state']";
    private static final String XPATH_INPUT_PIN = "//input[@name='pinno']";
    private static final String XPATH_INPUT_MOBILE_PHONE = "//input[@name='telephoneno']";
    private static final String XPATH_INPUT_EMAIL = "//input[@name='emailid']";
    private static final String XPATH_INPUT_PW= "//input[@name='password']";
    private static final String XPATH_SUBMIT_BUTTON = "//input[@value='Submit']";
    private static final String ID_SET_BUTTON = "button1";

    @FindBy(xpath = XPATH_INPUT_NAME) private WebElement inputName;
    @FindBy(xpath = XPATH_RADIO_MALE) private WebElement radioButtonMale;
    @FindBy(xpath = XPATH_RADIO_FEMALE) private WebElement radioButtonFemale;
    @FindBy(id = ID_SELECT_DOB) private WebElement selectDob;
    @FindBy(xpath = XPATH_INPUT_ADDRESS) private WebElement inputAddress;
    @FindBy(xpath = XPATH_INPUT_CITY) private WebElement inputCity;
    @FindBy(xpath = XPATH_INPUT_STATE) private WebElement inputState;
    @FindBy(xpath = XPATH_INPUT_PIN) private WebElement inputPin;
    @FindBy(xpath = XPATH_INPUT_MOBILE_PHONE) private WebElement inputMobilePhone;
    @FindBy(xpath = XPATH_INPUT_EMAIL) private WebElement inputEmail;
    @FindBy(xpath = XPATH_INPUT_PW) private WebElement inputPw;
    @FindBy(xpath = XPATH_SUBMIT_BUTTON) private WebElement submitBtn;

    public NewCustomerPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void submit() {
        submitBtn.click();
    }

    private void inputUserName(){
        inputName.sendKeys(getCustomer().getUserName());
    }

    private void selectGender(){
        if (getCustomer().getGender() == Gender.MALE){
            radioButtonMale.click();
        } else radioButtonFemale.click();
    }

    private void inputDob(){
        selectDob.click();
        AndroidDriver androidDriver = ((AndroidDriver)((WebDriverFacade) getDriver()).getProxiedDriver());
        androidDriver.context(MyDriverContext.NATIVE_APP.getContext());
        androidDriver.findElement(By.id(ID_SET_BUTTON)).click();
        androidDriver.context(MyDriverContext.CHROMIUM.getContext());
    }

    private void inputAddress(){
        inputAddress.sendKeys(getCustomer().getAddress());
    }

    private void inputCity(){
        inputCity.sendKeys(getCustomer().getCity());
    }

    private void inputState(){
        inputState.sendKeys(getCustomer().getState());
    }

    private void inputPin(){
        inputPin.sendKeys(getCustomer().getPin());
    }

    private void inputMobilePhone(){
        inputMobilePhone.sendKeys(getCustomer().getMobilePhone());
    }

    private void inputEmail(){
        inputEmail.sendKeys(getCustomer().getEmail());
    }

    private void inputPw(){
        inputPw.sendKeys(getCustomer().getPw());
    }

    public void fillForValidUser(){
        inputUserName();
        selectGender();
        inputDob();
        inputAddress();
        inputCity();
        inputState();
        inputPin();
        inputMobilePhone();
        inputEmail();
        inputPw();
        submit();
    }

    @Override
    public void waitForMainElementVisible() {
        waitForVisibility(inputName);
        waitForVisibility(submitBtn);
        // can check for more element if needed
    }

    @Override
    public void verify() {
        // implement if needed
    }
}

