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
    |Employee31   |anyPassword|
    |anyUsername  |anyPassword|

    Scenario: User can reset password
      Given the user clicks on Forgot password? button
      When the user enters "Mike@smith.com" email to user email input box
      And the user clicks on Reset password button
      Then Verify that message contains "A password reset message has been sent to the e-mail address of this account."



Scenario: user should not leave user input box blank
  Given the user enters "Employee123" to password input box
  When click on login button
  Then verify that "Please fill out this field." is dissplayed on "user input box"

  Scenario: user should not leave user input box blank
    Given the user enters "Employee31" to username input box
    When click on login button
    Then verify that "Please fill out this field." is dissplayed on "password input box"

  Scenario: username and password placeholders are dissplayed
    Then verify that username and password placeholders are dissplayed
@wip
    Scenario: username and password appears in a for of dots
    When the user enters following credentials
      |username|Employee31|
      |password |Employee123|
      Then Veriy that username and password appears in a for of dots

