Feature:
  Choose Feature https://dev.vgroll.com/

  Background:
    Given user opens the application
    And user login using admin@testcompany and 123


  Scenario Outline: Check calculation for one employee for last payroll

    When user selects Company mode on Main page
    And user opens Edit Company Details page
    And user opens Payroll Information Tab
    And user selects Pay Frequency as <Given Pay Frequency>
    And user saves updated Pay Frequency

    When user selects Payrolls mode on Main page
    And user gets dates for last payroll
    Then user creates new payroll for given dates depending on <Given Pay Frequency>
    And user saves new payroll
    And user refreshes Payroll screen

    Then user gets dates for new payroll
    And user gets pay frequency
    And user verifies day difference between new payroll and previous one

    Then user gets last payroll date
    And user opens dropdown list for last payroll
    And user selects Payroll Check option
    And user opens a Payroll Check form
    And user chooses given employee on Select screen <Given Employee>

    Then user calculates a new check for chosen employee <Given Employee>
    And user verifies calculated check for <Given Employee>, <Gross Wages>, <Net Wages>


    Examples:
      |Given Pay Frequency| Given Employee    |Gross Wages| Net Wages |
      |Weekly             | Purple            | 860.00    | 0.00      |
      |Monthly            | Armstrong         | 860.00    | 0.00      |




