package com.appium.serenirybdd.pages;

import com.appium.serenirybdd.constants.MyDriverContext;
import com.appium.serenirybdd.data.models.AccountType;
import com.appium.serenirybdd.error_hanlders.AutomationException;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

public class NewAccountPage extends BasePage {

    public NewAccountPage(WebDriver driver) {
        super(driver);
    }

    private static final String XPATH_INPUT_CUSTOMER_ID = "//input[@name='cusid']";
    private static final String XPATH_SELECT_ACCOUNT_TYPE = "//select[@name='selaccount']";
    private static final String ID_LIST_VIEW_SELECT_ACCOUNT = "android:id/text1";
    private static final String XPATH_INPUT_INIT_DEPOSIT = "//input[@name='inideposit']";
    private static final String XPATH_BUTTON_SUBMIT = "//input[@name='button2']";

    @FindBy(xpath = XPATH_INPUT_CUSTOMER_ID) private WebElement inputCustomerId;
    @FindBy(xpath = XPATH_SELECT_ACCOUNT_TYPE) private WebElement selectAccountType;
    @FindBy(xpath = XPATH_INPUT_INIT_DEPOSIT) private WebElement inputInitDesposit;
    @FindBy(xpath = XPATH_BUTTON_SUBMIT) private WebElement submitBtn;

    private void inputCustomerId(){
        inputCustomerId.sendKeys(getCustomer().getCustomerId());
    }

    private void inputInitDeposit(){
        inputInitDesposit.sendKeys(getCustomer().getDeposit());
        getCustomer().setBalance(getCustomer().getDeposit());
    }

    @Override
    public void submit() {
        submitBtn.click();
    }

    @SuppressWarnings("unchecked")
    private void selectCurrentAccount(final AccountType accountType){
        selectAccountType.click();
        AndroidDriver androidDriver = ((AndroidDriver)((WebDriverFacade) getDriver()).getProxiedDriver());
        androidDriver.context(MyDriverContext.NATIVE_APP.getContext());
        List<WebElement> listItems = androidDriver.findElements(By.id(ID_LIST_VIEW_SELECT_ACCOUNT));
        Optional<WebElement> optional = listItems.stream().filter(e -> e.getText().startsWith(accountType.toString())).findFirst();
        if (optional.isPresent())
            optional.get().click();
        else throw new AutomationException("Your account type is not existed in list view. Please check and try again");
        getCustomer().setAccountType(accountType);
        androidDriver.context(MyDriverContext.CHROMIUM.getContext());
    }

    public void createNewAccount(AccountType accountType){
        waitForMainElementVisible();
        inputCustomerId();
        inputInitDeposit();
        selectCurrentAccount(accountType);
        submit();
    }

    @Override
    public void waitForMainElementVisible() {
        waitForVisibility(inputCustomerId);
        waitForVisibility(selectAccountType);
        waitForVisibility(inputInitDesposit);
        waitForVisibility(submitBtn);
    }

    @Override
    public void verify() {
        // implement if needed
    }
}
