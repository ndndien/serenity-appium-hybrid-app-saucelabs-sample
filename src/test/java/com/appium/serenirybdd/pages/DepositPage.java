package com.appium.serenirybdd.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DepositPage extends BasePage {

    private static final String XPATH_INPUT_ACCOUNT_ID = "//input[@name='accountno']";
    private static final String XPATH_INPUT_AMOUNT = "//input[@name='ammount']";
    private static final String XPATH_INPUT_DESC = "//input[@name='desc']";
    private static final String XPATH_SUBMIT_BTN = "//input[@name='AccSubmit']";

    @FindBy(xpath = XPATH_INPUT_ACCOUNT_ID) private WebElement inputAccountId;
    @FindBy(xpath = XPATH_INPUT_AMOUNT) private WebElement inputAmount;
    @FindBy(xpath = XPATH_INPUT_DESC) private WebElement inputDesc;
    @FindBy(xpath = XPATH_SUBMIT_BTN) private WebElement submitBtn;

    public DepositPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void submit() {
        submitBtn.click();
    }

    private void inputAccountId(){
        inputAccountId.sendKeys(getCustomer().getAccountId());
    }

    private void inputAmount(int amountToDeposit){
        String amount = Integer.toString(amountToDeposit);
        inputAmount.sendKeys(amount);
        getCustomer().setDeposit(amount);
        getCustomer().setBalance(amount);
    }

    private void inputDesc(String desc){
        inputDesc.sendKeys(desc);
        getCustomer().setTransactionDesc(desc);
    }

    public void deposit(int amountToDeposit){
        inputAccountId();
        inputAmount(amountToDeposit);
        inputDesc("desc");
        submit();
    }

    @Override
    public void waitForMainElementVisible() {
        waitForVisibility(inputAccountId);
        waitForVisibility(inputAmount);
        waitForVisibility(submitBtn);
    }

    @Override
    public void verify() {
        // do nothing
    }
}
