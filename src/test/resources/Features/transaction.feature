@TransactionsTest
Feature: Test Features of Transaction

  Scenario: Adding products to Cart
    Given user is on inventory page
    When user clicks product 1 "Add to Cart" button
    And user clicks product 2 "Add to Cart" button
    Then cart counter should reflect number 2 based on the sum of products in cart

  Scenario: Removing a product to Cart
    Given user is on inventory page
    And user clicks product 1 "Add to Cart" button
    And user clicks product 2 "Add to Cart" button
    And cart counter should reflect number 2 based on the sum of products in cart
    When user clicks product 1 "Remove from Cart" button
    Then cart counter should reflect number 1 based on the sum of products in cart

  Scenario: Emptying Cart
    Given user is on inventory page
    And user clicks product 1 "Add to Cart" button
    And user clicks product 2 "Add to Cart" button
    And cart counter should reflect number 2 based on the sum of products in cart
    And user clicks product 1 "Remove from Cart" button
    And cart counter should reflect number 1 based on the sum of products in cart
    When user clicks product 2 "Remove from Cart" button
    Then cart counter should disappear

  Scenario Outline: Full Transaction
    Given user is on inventory page
    And user clicks product 1 "Add to Cart" button
    And user clicks product 2 "Add to Cart" button
    And cart counter should reflect number 2 based on the sum of products in cart
    When user click cart icon
    And user click "Checkout" button
    And user set the recipient data with <first_name>, <last_name>, <postal_code>
    And user click "Continue" button
    And user click "Finish" button
    Then user should see the transaction complete in the current page

    Examples: 
      | first_name | last_name | postal_code |
      | automation | testing   |     9188829 |
