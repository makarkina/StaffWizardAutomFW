Feature:
  Choose Feature https://dev.vgroll.com/

  Background:
    Given user opens the application
    And user login using admin@testcompany and 123

  Scenario Outline: Check calculation for all employees using Create Next Payroll button

    When user selects Company mode on Main page
    And user opens Edit Company Details page
    And user opens Payroll Information Tab
    And user selects Pay Frequency as <Given Pay Frequency>
    And user saves updated Pay Frequency

    When user selects Payrolls mode on Main page
    When user gets dates for last payroll
    And user creates next payroll on Payroll screen
    And user refreshes Payroll screen

    Then user gets dates for new payroll
    And user gets pay frequency
    And user verifies day difference between new payroll and previous one

    Then user gets last payroll date
    And user calculates all checks

    And user verifies date for each of calculated checks
    And user verifies number of calculated checks for <All Employees>

    Examples:
      |Given Pay Frequency| All Employees |
      |Weekly             | 10            |
