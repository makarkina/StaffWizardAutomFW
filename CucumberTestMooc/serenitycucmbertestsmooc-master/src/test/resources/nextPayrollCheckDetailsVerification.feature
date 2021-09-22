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

    And user selects Earning/Deduction <DD>, <CS>, <Levy>, <Pension>, <Earning>
    And user verifies amount for Earning/Deduction <Amount1>, <Amount2>, <Amount3>, <Amount4>, <Amount5>

    Examples:
     | Given Employee | DD | CS |Levy|Pension|Earning | Amount1 | Amount2 | Amount3 | Amount4 | Amount5 |
     | McDown         | DD | CS |Levy|Pension|Hourly  | 0.00    |         |         |         | 600.00  |
