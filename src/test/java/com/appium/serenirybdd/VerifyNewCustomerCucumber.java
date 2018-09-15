package com.appium.serenirybdd;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-html-report"},
        features = "src/test/java/com/appium/serenirybdd/resources/features/verify_new_customers.feature",
        glue = {"com.appium.serenirybdd.cucumber"})
public class VerifyNewCustomerCucumber {
}
