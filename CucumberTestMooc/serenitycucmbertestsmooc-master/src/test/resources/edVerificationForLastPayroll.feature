Feature:
  Choose Feature https://dev.vgroll.com/

  Background:
    Given user opens the application
    And user login using admin@testcompany and 123

  Scenario Outline: verification of ED amounts for last payroll date

    When user selects Payrolls mode on Main page
    Then user gets last payroll date
    And user verifies a pay frequency for last payroll <Pay Frequency>

    And user opens dropdown list for last payroll
    And user selects Payroll Check option

    Then user opens Payroll Check Details for an employee <Given Employee>
    And user verifies amount for Earning/Deduction <DD>, <CS>, <Levy>, <Garnishment>, <Pension>, <Hourly>, <Salary>, <Overtime>

    Examples:
    |Pay Frequency| Given Employee | DD      | CS     | Levy   |Garnishment|Pension| Hourly | Salary | Overtime |
    |Weekly       | Brown          | 476.18  |        |        |           |       | 600.00 |        |          |
    |Weekly       | Black          | 219.34  | 100    |        |           |       | 400.00 |        |          |
    |Weekly       | Armstrong      | 729.55  | 100    |        |           |       |        |1153.85 |          |
    |Weekly       | Red            | 252.86  |        |        |  100      |       | 400.00 |        |          |
    |Weekly       | Green          | 435.67  |        |  100   |           |       | 680.00 |        |          |
    |Weekly       | McDown         | 813.05  |        |        |  100      |       |         |1153.85|          |
    |Weekly       | Yellow         | 386.40  | 100    |        |  100      | 18    | 600.00 |        |          |
    |Weekly       | Purple         | 493.48  | 100    |        |  100      | 10    | 860.00 |        |          |
    |Weekly       | Douglass       | 951.97  |        |        |           |       | 1153.85|        |          |
    |Weekly       | White          | 525.43  |        |        |           |       | 660.00 |        |          |