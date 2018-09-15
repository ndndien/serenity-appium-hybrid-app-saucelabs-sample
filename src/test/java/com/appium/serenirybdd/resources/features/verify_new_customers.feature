Feature: Verify New Customers

  Background: Log in to system
    Given Log in to system

  Scenario: Verify new customer can be created
    And User opens tab New Customer
    And User creates new customer
    Then Verify customer just created

  Scenario: Verify to created new account base on customer just created
    Given User opens tab New Account
    And User creates new account base on customer just created
    Then Verify account has created

  Scenario: Deposit and verify transaction
    Given User opens tab Deposit
    And User deposits to savings account
    Then Verify deposit transaction