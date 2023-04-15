Feature: feature to test login functionality

  Scenario: Check login is successful with valid credentials
    Given user browser is open
    And user is on login page
    When user enters <username> and <password>
    And clicks on login button
    Then user is navigated to the home page

   Examples:
   | username | password |
   | EarlHans | 12345 |
   | Kristy | 12345 |