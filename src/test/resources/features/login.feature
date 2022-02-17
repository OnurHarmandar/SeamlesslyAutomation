Feature: Login Functionality
  Background:
    Given the user navigates to login page

  Scenario: User logs in with valid credentials
    When the user enters following credentials
      |username|Employee31|
      |password |Employee123|
    And click on login button
    Then Verify that user is on "Dashboard" page
    When click on user avatar
    Then Verify that "username" is displayed in dropdown

  Scenario: User logs in with valid credentials with ENTER button on keyboard

    When the user enters following credentials
      |username|Employee31|
      |password |Employee123|
    And Press Enter button on keyboard
    Then Verify that user is on "Dashboard" page
    When click on user avatar
    Then Verify that "username" is displayed in dropdown

  Scenario Outline: User CAN NOT logs in with invalid credentials
  When the user enters following credentials
    |username|<username>|
    |password |<password>|
    And click on login button
  Then Verify "Wrong username or password." massage is displayed

  Examples:
    | username    | password  |
    |Employeee    |Employee123|
   # |Employee31   |anyPassword|
   # |anyUsername  |anyPassword|


