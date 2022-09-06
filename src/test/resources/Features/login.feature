Feature: Feature to test login functionality

  Scenario: Login failed - Empty username and password
    Given user is on login page
    When clicks on login button
    Then user should see a failed login alert <alert_text>
    
   Examples:
   |alert_text|
   |Epic sadface: Username is required|
   

  Scenario Outline: Login failed - Fill username and password wrongly
    Given user is on login page
    When user enters <username> and <password>
    And clicks on login button
    Then user should see a failed login alert <alert_text>

    Examples: 
      | username      | password | alert_text                                                            |
      | standard_user |          | Epic sadface: Password is required                                        |
      | standard_user |      123 | Epic sadface: Username and password do not match any user in this service |

  Scenario Outline: Login is successfull
    Given user is on login page
    When user enters <username> and <password>
    And clicks on login button
    Then user is navigated to the inventory page

    Examples: 
      | username      | password     |
      | standard_user | secret_sauce |
