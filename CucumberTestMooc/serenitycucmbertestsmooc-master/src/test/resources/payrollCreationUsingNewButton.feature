Feature:
  Choose Feature https://dev.vgroll.com/

  Background:
    Given user opens the application
    And user login using admin@testcompany and 123

  Scenario Outline: Payroll creation for all employees using Create New Payroll button

    When user selects Company mode on Main page
    And user opens Edit Company Details page
    And user opens Payroll Information Tab
    And user selects Pay Frequency as <Given Pay Frequency>
    And user saves updated Pay Frequency

    When user selects Payrolls mode on Main page
    And user gets dates for last payroll
    Then user creates new payroll for given dates
    And user saves new payroll
    And user refreshes Payroll screen

    Then user gets dates for new payroll
    And user gets pay frequency
    Then user verifies day difference between new payroll and previous one
    And user verifies Period Begin Date for new payroll
    And user verifies Period End Date for new payroll

    Examples:
      | Given Pay Frequency |
      | Weekly              |
