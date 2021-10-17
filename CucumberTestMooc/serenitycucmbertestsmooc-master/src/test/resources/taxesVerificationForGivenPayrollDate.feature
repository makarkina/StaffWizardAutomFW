Feature:
  Choose Feature https://dev.vgroll.com/

  Background:
    Given user opens the application
    And user login using admin@testcompany and 123
    When user selects Payrolls mode on Main page


  Scenario Outline: tax verification for given payroll date

    When user selects payroll with <Given Check date>
    And user verifies a pay frequency for given payroll date <Pay Frequency>
    And user selects Payroll Check option
    And user verifies <Given Check date> on selected check

    Then user opens Edit Check for chosen employee <Given Employee>
    Then user verifies federal taxes <Federal Tax>, <EE OASDI Tax>, <EE Medicare Tax>, <FUI Tax>
    And user verifies state taxes <State Tax>, <SDI Tax>

    Examples:
     |Given Check date |Pay Frequency  |Given Employee |Federal Tax|EE OASDI Tax|EE Medicare Tax|FUI Tax|State Tax|SDI Tax|
     |03/21/2025       |Weekly         |Brown          |59.06      | 37.20      |  8.70         |36.00  | 11.66  |  7.2   |
     |04/30/2025       |Weekly         |Douglass       |82.81      | 71.54      |  16.73        |69.23  | 30.80  |        |
     |03/14/2025       |Every Two Weeks|Armstrong      |310.75     | 143.08     |  33.46        |138.46 | 161.31 |        |
     |04/22/2025       |Monthly        |McDown         |673.29     | 310.00     |  72.50        |300.00 | 97.50  | 23.50  |



