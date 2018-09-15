package com.appium.serenirybdd.cucumber;

import com.appium.serenirybdd.serenity.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class VerifyNewCustomerScenarioSteps {

    @Steps
    LoginToBankSteps loginToBankSteps;

    @Steps
    MainPageSteps mainPageSteps;

    @Steps
    NewCustomerSteps newCustomerSteps;

    @Steps
    NewAccountSteps newAccountSteps;

    @Steps
    DepositSteps depositSteps;

    @Given("^Log in to system$")
    public void log_in_to_system() {
        loginToBankSteps.loginToSystem();
    }

    @And("^User opens tab New Customer$")
    public void user_opens_tab_New_Customer() {
        mainPageSteps.openNewCustomerTab();
    }

    @And("^User creates new customer$")
    public void user_creates_new_customer(){
        newCustomerSteps.createNewCustomer();
    }

    @Then("^Verify customer just created$")
    public void verify_customer_just_created(){
        newCustomerSteps.verifyCreatedCustomer();
    }

    @Given("^User opens tab New Account")
    public void user_opens_tab_New_Account(){
        mainPageSteps.openNewAccountTab();
    }

    @And("^User creates new account base on customer just created$")
    public void user_creates_new_account_base_on_customer_just_created(){
        newAccountSteps.createNewAccount();
    }

    @Then("^Verify account has created$")
    public void verify_account_has_created(){
        newAccountSteps.verifyCreatedAccount();
    }

    @Given("^User opens tab Deposit$")
    public void user_opens_tab_Deposit(){
        mainPageSteps.openDepositTab();
    }

    @And("^User deposits to savings account$")
    public void user_deposits_to_savings_account(){
        depositSteps.deposit();
    }

    @Then("^Verify deposit transaction$")
    public void verify_deposit_transaction(){
        depositSteps.verifyDeposit();
    }
}
