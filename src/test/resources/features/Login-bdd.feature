@All
Feature: Login

  @Login @Positive
  Scenario: Login
    Given User is on login page
    When User fill username and password
    And User click login bottom
    Then User verify login result

  @Login @Negative
  Scenario: Invalid Login
    Given User is on login page
    When User fill invalid username and password
    And User click login bottom
    Then User get error message
