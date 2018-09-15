package com.appium.serenirybdd.data.models;

import com.appium.serenirybdd.utlis.DateUtils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {
    @JsonProperty("userName") private String userName;
    @JsonProperty("gender") private Gender gender;
    @JsonProperty("dob") private String dob;
    @JsonProperty("address") private String address;
    @JsonProperty("city") private String city;
    @JsonProperty("state") private String state;
    @JsonProperty("customerId") private String customerId;
    @JsonProperty("accountId") private String accountId;
    @JsonProperty("accountType") private AccountType accountType;
    @JsonProperty("deposit") private String deposit;
    @JsonProperty("transactionDesc") private String transactionDesc;
    @JsonProperty("balance") private String balance = "0";
    @JsonProperty("pin") private String pin;
    @JsonProperty("mobilePhone") private String mobilePhone;
    @JsonProperty("email") private String email;
    @JsonProperty("pw") private String pw;

    public String getUserName() {
        return userName;
    }

    public Gender getGender() {
        return gender;
    }

    public String getDob() {
        this.dob = DateUtils.getCurrentDate();
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPin() {
        return pin;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public String getPw() {
        return pw;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit){
        this.deposit = deposit;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = Integer.toString(Integer.parseInt(this.balance) + Integer.parseInt(balance));
    }

    public String getTransactionDesc() {
        return transactionDesc;
    }

    public void setTransactionDesc(String transactionDesc) {
        this.transactionDesc = transactionDesc;
    }
}
