Feature:
  Choose Feature https://dev.vgroll.com/

  Background:
    Given user opens the application
    And user login using admin@testcompany and 123


  Scenario Outline: Check calculation for one employee on a given date

    When user selects Company mode on Main page
    And user opens Edit Company Details page
    And user opens Payroll Information Tab
    And user selects Pay Frequency as <Given Pay Frequency>
    And user saves updated Pay Frequency

    When user selects Payrolls mode on Main page
    And user creates new payroll on Payroll screen
    And user enters <Period begin date>, <Period end date>, <Check date>,
    And user saves new payroll
    And user refreshes Payroll screen

    When user selects payroll with <Given Check date>
    And user selects Payroll Check option
    And user opens a Payroll Check form
    And user chooses given employee on Select screen <Given Employee>

    Then user calculates a new check for chosen employee <Given Employee>
    And user verifies <Given Check date> on selected check
    And user verifies calculated check for <Given Employee>, <Gross Wages>, <Net Wages>


    Examples:
      |Given Pay Frequency| Check date   | Period begin date  | Period end date  | Given Check date | Given Employee    |Gross Wages| Net Wages |
      |Weekly             | 09/11/2024   | 09052024           | 09112024         | 09/11/2024       | George J Yellow   | 600.00    | 0.00      |
      |Weekly             | 06/19/2024   | 06132024           | 06192024         | 06/19/2024       | Olga Red          | 400.00    | 0.00      |






