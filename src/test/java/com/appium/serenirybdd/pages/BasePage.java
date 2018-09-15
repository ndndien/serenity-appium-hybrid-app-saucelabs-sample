package com.appium.serenirybdd.pages;

import com.appium.serenirybdd.data.DataManager;
import com.appium.serenirybdd.data.models.Customer;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class BasePage extends PageObject {

    private static final Logger LOGGER = Logger.getLogger(BasePage.class);
    private static final int MAX_TIME_TO_WAIT = 30;
    private final Customer customer;

    public BasePage(final WebDriver driver) {
        super(driver, page -> {
            PageFactory.initElements(new AppiumFieldDecorator( ((WebDriverFacade) page.getDriver()).getProxiedDriver(), page.getImplicitWaitTimeout()), page);
            return true;
        });
        this.customer  = DataManager.getCustomer();
    }
    Customer getCustomer(){
        return this.customer;
    }

    public abstract void submit();

    public abstract void waitForMainElementVisible();

    public abstract void verify();

    void waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), MAX_TIME_TO_WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    private void waitForClickAble(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), MAX_TIME_TO_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    @Override
    public void clickOn(WebElement webElement){
        waitForClickAble(webElement);
        webElement.click();
    }

    void sleep(int seconds) {
        try {
            LOGGER.info("Sleep : " + seconds + " seconds");
            TimeUnit.SECONDS.sleep((long)seconds*1000);
        } catch (InterruptedException e) {
            LOGGER.debug(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
