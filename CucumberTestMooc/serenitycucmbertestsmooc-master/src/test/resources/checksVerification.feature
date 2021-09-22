Feature:
  Choose Feature https://dev.vgroll.com/

  Background:
    Given user opens the application
    And user login using anna and 234
    And user selects Payrolls mode on Main page

  Scenario: Positive test

    Then user gets last check date
    And user calculates all checks

    Then user opens a Payroll Checks screen
    And user verifies number of calculated checks





