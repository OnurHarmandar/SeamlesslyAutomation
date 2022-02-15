Feature: Login Functionality
@wip
  Scenario: User logs in with valid credentials
    Given the user navigates to login page
    When the user enters following credentials
      |username|Employee31|
      |password |Employee123|
    And click on login button
    Then Verify that user is on "Dashboard" page
    When click on user avatar
    Then Verify that "username" is displayed in dropdown