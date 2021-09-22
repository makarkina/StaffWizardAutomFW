Feature:
  Choose Feature https://dev.vgroll.com/

  Background:
    Given user opens the application
    And user login using anna and 234
    When user selects Payrolls mode on Main page

  Scenario Outline: Check calculation for one employee when

    When user creates new payroll on Payroll screen
    And user enters <Period begin date>, <Period end date>, <Check date>,
    And user saves new payroll

    Then user selects Payroll with <Given Check date> on Payroll screen
    And user selects Payroll Check option

    Then user opens a Payroll Check form
    And user chooses given employee on Select screen <Given Employee>

    Then user calculates a new check for chosen employee <Given Employee>
    And user verifies calculated check for <Given Employee> and <Gross Wages>


    Examples:
      | Check date   | Period begin date  | Period end date  | Given Check date | Given Employee    |Gross Wages|
      | 11052031     | 10302031           | 11052031         | 11/05/2031       | Victor Green      | 600.00    |




