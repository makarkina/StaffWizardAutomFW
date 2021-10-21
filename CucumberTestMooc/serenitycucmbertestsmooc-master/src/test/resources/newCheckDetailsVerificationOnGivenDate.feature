Feature:
  Choose Feature https://dev.vgroll.com/

  Background:
    Given user opens the application
    And user login using admin@testcompany and 123
    When user selects Payrolls mode on Main page


  Scenario Outline: verification of adding new check details to payroll with given date

    When user selects payroll with <Check Date>
    And user verifies a pay frequency for given payroll date <Pay Frequency>
    And user selects Payroll Check option
    And user verifies <Check Date> on selected check

    Then user opens Edit Check for chosen employee <Given Employee>
    And user clicks Payroll Check Details Tab
    And user opens new Payroll Check Details on Edit Payroll Check screen
    And user adds new Payroll Check Detail with <Given ED>, <State>, <Hours>, <Pay Rate>
    And user saves new Payroll Check Details

    Then user clicks Save button on Edit Payroll Check screen
    And user calculates a new check for chosen employee <Given Employee>
    And user verifies calculated check for <Given Employee>, <Gross Wages>, <Net Wages>


    Examples:
      |Pay Frequency|Check Date|Given Employee |Given ED     |State|Hours  |Pay Rate|Gross Wages|Net Wages|
      |Weekly       |06/19/2024|Olga Red       |Overtime     |TX   |10.00  |10.00   |550.00     |0.00     |
      |Weekly       |09/11/2024|George J Yellow|HOURS        |IL   |10.00  |15.00   |825.00     |0.00     |



