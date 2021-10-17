Feature:
  Choose Feature https://dev.vgroll.com/

  Background:
    Given user opens the application
    And user login using admin@testcompany and 123

  Scenario Outline: verification of ED amounts for a payroll with given date

    When user selects Payrolls mode on Main page
    And user selects payroll with <Given Check Date>
    And user verifies a pay frequency for given payroll date <Pay Frequency>
    And user selects Payroll Check option

    Then user opens Payroll Check Details for an employee <Given Employee>
    And user verifies amount for Earning/Deduction <DD>, <CS>, <Levy>, <Garnishment>, <Pension>, <Hourly>, <Salary>, <Overtime>

    Examples:
      |Pay Frequency  |Given Check Date|Given Employee    | DD      | CS     | Levy   |Garnishment|Pension| Hourly | Salary | Overtime |
      |Weekly         | 12/31/2024     |Michael Purple    |493.48   | 100.00 |        | 100.00    |10.00  |860.00  |        |          |
      |Weekly         | 04/30/2025     |Victoria McDown   |813.05   |        |        |           |69.23  |        | 1153.85|          |
      |Every Two Weeks| 03/14/2025     |Louis J Armstrong |1559.09  | 100.00 |        |           |       |        | 2307.69|          |
      |Monthly        | 04/22/2025     |Victoria McDown   |3523.21  |        |        |           |300.00 |        | 5000.00|          |


