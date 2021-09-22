Feature:
  Choose Feature https://dev.vgroll.com/

  Background:
    Given user opens the application
    And user login using anna and 234
    When user selects Payrolls mode on Main page

  Scenario Outline: Check calculation for one employee using Start New Payroll button

    When user gets dates for last payroll
    Then user creates new payroll for given dates
    And user saves new payroll
    And user refreshes Payroll screen

    Then user gets dates for new payroll
    And user gets pay frequency
    And user verifies day difference between new payroll and previous one

    Then user gets last check date
    And user selects Payroll Check option
    And user opens a Payroll Check form
    And user chooses given employee on Select screen <Given Employee>

    Then user calculates a new check for chosen employee <Given Employee>
    And user verifies calculated check for <Given Employee>, <Gross Wages>, <Net Wages>


    Examples:
     | Given Employee    |Gross Wages| Net Wages |
     | Victor Green      | 600.00    | 0.00      |
     | Louis J Armstrong | 1153.85   | 0.00      |




