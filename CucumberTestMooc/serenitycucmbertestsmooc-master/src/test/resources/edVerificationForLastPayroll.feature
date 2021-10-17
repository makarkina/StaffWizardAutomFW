Feature:
  Choose Feature https://dev.vgroll.com/

  Background:
    Given user opens the application
    And user login using admin@testcompany and 123

  Scenario Outline: verification of ED amounts for last payroll date

    When user selects Payrolls mode on Main page
    And user gets last payroll date
    And user gets pay frequency

    And user opens dropdown list for last payroll
    And user selects Payroll Check option

    Then user opens Payroll Check Details for an employee <Given Employee>
    And user verifies amount for Earning/Deduction <DD>, <CS>, <Levy>, <Garnishment>, <Pension>, <Hourly>, <Salary>, <Overtime>

    Examples:
      | Given Employee | DD      | CS     | Levy   |Garnishment|Pension| Hourly | Salary | Overtime |
      | Brown          | 476.18  |        |        |           |       | 600.00 |        |          |
      | Black          | 219.34  | 100    |        |           |       | 400.00 |        |          |
      | Armstrong      | 729.55  | 100    |        |           |       |        |1153.85 |          |
      | Red            | 252.86  |        |        |  100      |       | 400.00 |        |          |
      | Green          | 435.67  |        |  100   |           |       | 680.00 |        |          |
      | McDown         | 813.05  |        |        |  100      |       |         |1153.85|          |
      | Yellow         | 386.40  | 100    |        |  100      | 18    | 600.00 |        |          |
      | Purple         | 493.48  | 100    |        |  100      | 10    | 860.00 |        |          |
      | Douglass       | 951.97  |        |        |           |       | 1153.85|        |          |
      | White          | 525.43  |        |        |           |       | 660.00 |        |          |