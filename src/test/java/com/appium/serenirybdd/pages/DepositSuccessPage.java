package com.appium.serenirybdd.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class DepositSuccessPage extends BasePage {

    private static final String XPATH_TRANSACTION_ID = "//tr/td[text()='Transaction ID']/following-sibling::td";
    private static final String XPATH_ACCOUNT_ID = "//tr/td[text()='Account No']/following-sibling::td";
    private static final String XPATH_ACCOUNT_CREDITED = "//tr/td[text()='Amount Credited']/following-sibling::td";
    private static final String XPATH_TYPE_OF_TRANSACTION = "//tr/td[text()='Type of Transaction']/following-sibling::td";
    private static final String XPATH_DESCRIPTION = "//tr/td[text()='Description']/following-sibling::td";
    private static final String XPATH_CURRENT_BALANCE = "//tr/td[text()='Current Balance']/following-sibling::td";

    @FindBy(xpath = XPATH_TRANSACTION_ID) private WebElement transactionId;
    @FindBy(xpath = XPATH_ACCOUNT_ID) private WebElement accountId;
    @FindBy(xpath = XPATH_ACCOUNT_CREDITED) private WebElement accountCredited;
    @FindBy(xpath = XPATH_TYPE_OF_TRANSACTION) private WebElement typeOfTransaction;
    @FindBy(xpath = XPATH_DESCRIPTION) private WebElement transactionDesc;
    @FindBy(xpath = XPATH_CURRENT_BALANCE) private WebElement currentBalance;

    public DepositSuccessPage(WebDriver driver) {
        super(driver);
    }

    private void verifyAccountId(){
        assertEquals(getCustomer().getAccountId(), accountId.getText());
    }

    private void verifyAccountCredited(){
        assertEquals(getCustomer().getDeposit(), accountCredited.getText());
    }

    private void verifyTypeOfTransaction(){
        assertEquals("Deposit", typeOfTransaction.getText());
    }

    private void verifyTransactionDesc(){
        assertEquals(getCustomer().getTransactionDesc(), transactionDesc.getText());
    }

    private void verifyCurrentBalance(){
        assertEquals(getCustomer().getBalance(), currentBalance.getText());
    }

    @Override
    public void submit() {
        // do nothing
    }

    @Override
    public void waitForMainElementVisible() {
        waitForVisibility(transactionId);
        waitForVisibility(accountId);
        waitForVisibility(accountCredited);
        waitForVisibility(typeOfTransaction);
        waitForVisibility(transactionDesc);
        waitForVisibility(currentBalance);
    }

    @Override
    public void verify() {
        verifyAccountId();
        verifyAccountCredited();
        verifyTransactionDesc();
        verifyTypeOfTransaction();
        verifyCurrentBalance();
    }
}
