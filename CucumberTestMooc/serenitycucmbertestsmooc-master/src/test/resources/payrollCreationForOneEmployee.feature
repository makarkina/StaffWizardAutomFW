Feature:
  Choose Feature https://dev.vgroll.com/

  Background:
    Given user opens the application
    And user login using anna and 123
    And user selects Payrolls mode on Main page

  Scenario Outline: Positive test

    When user creates new payroll on Payroll screen
    And user enters <Period begin date>, <Period end date>, <Check date>,
    And user saves new payroll
    Then user selects Payroll with <Given Check date> on Payroll screen
    And user verifies check date for <Given Check date>

    Examples:
      | Check date  | Period begin date | Period end date | Given Check date |
      | 11262029    | 11202029          | 11262029        | 11/26/2029       |
      | 12102029    | 11272029          | 12102029        | 12/10/2029       |


