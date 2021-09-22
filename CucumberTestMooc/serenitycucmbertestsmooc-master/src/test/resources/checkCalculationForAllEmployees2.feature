Feature:
  Choose Feature https://dev.vgroll.com/

  Background:
    Given user opens the application
    And user login using anna and 234
    When user selects Payrolls mode on Main page

  Scenario Outline: Check calculation for all employee using Start New Payroll button

    When user gets dates for last payroll 
    And user creates next payroll on Payroll screen
    And user refreshes Payroll screen

    Then user gets dates for new payroll
    And user gets pay frequency
    And user verifies day difference between new payroll and previous one

    Then user gets last check date
    And user creates payroll checks
    And user calculates all checks

    Then user opens a Payroll Checks screen
    And user verifies date for each of calculated checks
    And user verifies number of calculated checks for <All Employees>

    Examples:
      | All Employees |
      | 10            |

