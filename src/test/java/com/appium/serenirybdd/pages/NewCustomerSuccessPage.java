package com.appium.serenirybdd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;

public class NewCustomerSuccessPage extends BasePage {

    public NewCustomerSuccessPage(WebDriver driver) {
        super(driver);
    }

    private static final String XPATH_CUSTOMER_ID = "//tr/td[text()='Customer ID']/following-sibling::td";
    private static final String XPATH_CUSTOMER_NAME = "//tr/td[text()='Customer Name']/following-sibling::td";
    private static final String XPATH_GENDER_NAME = "//tr/td[text()='Gender']/following-sibling::td";
    private static final String XPATH_DOB = "//tr/td[text()='Birthdate']/following-sibling::td";
    private static final String XPATH_ADDRESS = "//tr/td[text()='Address']/following-sibling::td";
    private static final String XPATH_CITY = "//tr/td[text()='City']/following-sibling::td";
    private static final String XPATH_STATE = "//tr/td[text()='State']/following-sibling::td";
    private static final String XPATH_PIN = "//tr/td[text()='Pin']/following-sibling::td";
    private static final String XPATH_MOBILE_NO = "//tr/td[text()='Mobile No.']/following-sibling::td";
    private static final String XPATH_EMAIL = "//tr/td[text()='Email']/following-sibling::td";

    @FindBy(xpath = XPATH_CUSTOMER_ID) private WebElement customerId;
    @FindBy(xpath = XPATH_CUSTOMER_NAME) private WebElement customerName;
    @FindBy(xpath = XPATH_GENDER_NAME) private WebElement customerGender;
    @FindBy(xpath = XPATH_DOB) private WebElement customerDob;
    @FindBy(xpath = XPATH_ADDRESS) private WebElement customerAddress;
    @FindBy(xpath = XPATH_CITY) private WebElement customerCity;
    @FindBy(xpath = XPATH_STATE) private WebElement customerState;
    @FindBy(xpath = XPATH_PIN) private WebElement customerPin;
    @FindBy(xpath = XPATH_MOBILE_NO) private WebElement customerMobileNo;
    @FindBy(xpath = XPATH_EMAIL) private WebElement customerEmail;

    private void setCustomerId(){
        getCustomer().setCustomerId(customerId.getText().trim());
    }

    private void verifyCustomerName(){
        assertEquals(getCustomer().getUserName(), customerName.getText());
    }

    private void verifyCustomerGender(){
        assertEquals(getCustomer().getGender().toString(), customerGender.getText());
    }

    private void verifyCustomerDob(){
        assertEquals(getCustomer().getDob(), customerDob.getText());
    }

    private void verifyCustomerAddress(){
        assertEquals(getCustomer().getAddress(), customerAddress.getText());
    }

    private void verifyCustomerCity(){
        assertEquals(getCustomer().getCity(), customerCity.getText());
    }

    private void verifyCustomerState(){
        assertEquals(getCustomer().getState(), customerState.getText());
    }

    private void verifyCustomerPin(){
        assertEquals(getCustomer().getPin(), customerPin.getText());
    }

    private void verifyCustomerMobilePhone(){
        assertEquals(getCustomer().getMobilePhone(), customerMobileNo.getText());
    }

    private void verifyCustomerEmail(){
        assertEquals(getCustomer().getEmail(), customerEmail.getText());
    }

    @Override
    public void waitForMainElementVisible() {
        waitForVisibility(customerId);
        waitForVisibility(customerName);
        waitForVisibility(customerGender);
        waitForVisibility(customerDob);
        waitForVisibility(customerAddress);
        waitForVisibility(customerCity);
        waitForVisibility(customerState);
        waitForVisibility(customerPin);
        waitForVisibility(customerMobileNo);
        waitForVisibility(customerEmail);
    }

    @Override
    public void verify() {
        setCustomerId();
        verifyCustomerName();
        verifyCustomerGender();
        verifyCustomerDob();
        verifyCustomerAddress();
        verifyCustomerState();
        verifyCustomerCity();
        verifyCustomerPin();
        verifyCustomerMobilePhone();
        verifyCustomerEmail();
    }

    @Override
    public void submit() {
        // do nothing
    }
}
