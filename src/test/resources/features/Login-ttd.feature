Feature: Login With TTD

  @TTD
  Scenario Outline: Login with TTD
    Given User is on login page
    When User input <username> and <password>
    And User click login bottom
    Then User verify login <result>

    Examples:
    |username| |password| |result|
    |standard_user| |secret_sauce| |True|
    |invalidUsername| |secret_sauce| |Failed|
    |standard_user| |invalidPassword| |Failed|