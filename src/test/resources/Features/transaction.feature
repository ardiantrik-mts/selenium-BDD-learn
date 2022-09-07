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
    