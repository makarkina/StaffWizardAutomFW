Feature:
  Choose Feature https://dev.vgroll.com/

  Background:
    Given user opens the application
    And user login using anna and 234

  Scenario Outline: Positive test

    When user selects Payrolls mode on Main page
    And user gets last check date
    And user selects Payroll Check option

    Then user opens Edit Check for chosen employee <Given Employee>
    And user opens Payroll Check Details
    And user verifies amount for Earning/Deduction <DD>, <CS>, <Levy>, <Garnishment>, <Pension>, <Hourly>, <Salary>, <Overtime>

    Examples:
     | Given Employee | DD      | CS     | Levy   |Garnishment|Pension| Hourly | Salary | Overtime |
     | Douglass       | 200.00  |        |        |           |       | 1000.00|        |          |
     | Black          | 143.21  | 100.00 | 100.00 |           |       | 800.00 |        |  75.00   |
     | Armstrong      | 576.16  | 150.00 | 200.00 |           | 69.23 |        | 1153.85|          |
     | McDown         | 0.00    |        |        |   100     |       | 600.00 |        |          |
