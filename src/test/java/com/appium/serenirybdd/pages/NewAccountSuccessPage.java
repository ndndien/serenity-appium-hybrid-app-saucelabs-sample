package com.appium.serenirybdd.pages;

import com.appium.serenirybdd.utlis.DateUtils;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class NewAccountSuccessPage extends BasePage {

    public NewAccountSuccessPage(WebDriver driver) {
        super(driver);
    }

    private static final String XPATH_ACCOUNT_ID = "//tr/td[text()='Account ID']/following-sibling::td";
    private static final String XPATH_CUSTOMER_ID = "//tr/td[text()='Customer ID']/following-sibling::td";
    private static final String XPATH_CUSTOMER_NAME = "//tr/td[text()='Customer Name']/following-sibling::td";
    private static final String XPATH_CUSTOMER_EMAIL = "//tr/td[text()='Email']/following-sibling::td";
    private static final String XPATH_ACCOUNT_TYPE = "//tr/td[text()='Account Type']/following-sibling::td";
    private static final String XPATH_DATE_OF_OPENING = "//tr/td[text()='Date of Opening']/following-sibling::td";
    private static final String XPATH_CURRENT_AMOUNT = "//tr/td[text()='Current Amount']/following-sibling::td";

    @FindBy(xpath = XPATH_ACCOUNT_ID) private WebElement accountId;
    @FindBy(xpath = XPATH_CUSTOMER_ID) private WebElement customerId;
    @FindBy(xpath = XPATH_CUSTOMER_NAME) private WebElement customerName;
    @FindBy(xpath = XPATH_CUSTOMER_EMAIL) private WebElement customerEmail;
    @FindBy(xpath = XPATH_ACCOUNT_TYPE) private WebElement accountType;
    @FindBy(xpath = XPATH_DATE_OF_OPENING) private WebElement dateOfOpening;
    @FindBy(xpath = XPATH_CURRENT_AMOUNT) private WebElement currentAmount;

    private void setAccountId(){
        getCustomer().setAccountId(accountId.getText());
    }

    private void verifyCustomerId(){
        assertEquals(getCustomer().getCustomerId(), customerId.getText());
    }

    private void verifyCustomerName(){
        assertEquals(getCustomer().getUserName(), customerName.getText());
    }

    private void verifyCustomerEmail(){
        assertEquals(getCustomer().getEmail(), customerEmail.getText());
    }

    private void verifyAccountType(){
        assertEquals(getCustomer().getAccountType().toString(), accountType.getText());
    }

    private void verifyDateOfOpening(){
        assertEquals(DateUtils.getCurrentDate(), dateOfOpening.getText());
    }

    private void verifyAmount(){
        assertEquals(getCustomer().getDeposit(), currentAmount.getText());
    }

    @Override
    public void waitForMainElementVisible() {
        waitForVisibility(accountId);
        waitForVisibility(customerId);
        waitForVisibility(customerName);
        waitForVisibility(customerEmail);
        waitForVisibility(accountType);
        waitForVisibility(dateOfOpening);
        waitForVisibility(currentAmount);
    }

    @Override
    public void verify() {
        setAccountId();
        verifyCustomerId();
        verifyCustomerName();
        verifyCustomerEmail();
        verifyAccountType();
        verifyDateOfOpening();
        verifyAmount();
    }

    @Override
    public void submit() {
        // do nothing
    }
}
