@All
Feature: Login

  @Login
  Scenario:
    Given User is on login page
    When User fill username and password
    And User click login bottom
    Then User verify login result
