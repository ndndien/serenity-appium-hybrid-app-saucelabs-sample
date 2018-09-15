package com.appium.serenirybdd.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {
    private static final String XPATH_NEW_CUSTOMER_TAB = "//li/a[text()='New Customer']";
    private static final String XPATH_EDIT_CUSTOMER_TAB = "//li/a[text()='Edit Customer']";
    private static final String XPATH_NEW_ACCOUNT_TAB = "//li/a[text()='New Account']";
    private static final String XPATH_DEPOSIT_TAB = "//li/a[text()='Deposit']";

    @FindBy(xpath = XPATH_NEW_CUSTOMER_TAB) private WebElement newCustomerTab;
    @FindBy(xpath = XPATH_EDIT_CUSTOMER_TAB) private WebElement editCustomerTab;
    @FindBy(xpath = XPATH_NEW_ACCOUNT_TAB) private WebElement newAccountTab;
    @FindBy(xpath = XPATH_DEPOSIT_TAB) private WebElement depositTab;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void submit() {
        // do nothing
    }

    public void openNewCustomerTab(){
        waitForMainElementVisible();
        newCustomerTab.click();
    }

    public void openNewAccountTab(){
        waitForVisibility(newAccountTab);
        newAccountTab.click();
    }

    public void openDepositTab(){
        waitForVisibility(depositTab);
        depositTab.click();
    }

    @Override
    public void waitForMainElementVisible() {
        waitForVisibility(newCustomerTab);
        waitForVisibility(editCustomerTab);
    }

    @Override
    public void verify() {
        // implement if needed
    }
}
