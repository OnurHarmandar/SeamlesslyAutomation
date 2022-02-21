Feature: Log out functionality
@SEAMLES-1392
  Scenario: User should be able to log out by clicking log out button
    Given the user logged in
    When click on user avatar
    And click on log out button
    Then The user comes back to login page
 @SEAMLES-1394
  Scenario: User should be able to log out by clicking log out button
    Given the user logged in
    When click on user avatar
    And click on log out button
    Then The user comes back to login page
    And the user navigates to back
    Then the user comes back to login page again