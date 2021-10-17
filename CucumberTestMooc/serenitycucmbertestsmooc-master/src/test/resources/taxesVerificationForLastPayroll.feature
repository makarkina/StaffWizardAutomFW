Feature:
  Choose Feature https://dev.vgroll.com/

  Background:
    Given user opens the application
    And user login using admin@testcompany and 123
    When user selects Payrolls mode on Main page

  Scenario Outline: tax verification for last payroll

    Then user gets last payroll date
    And user verifies a pay frequency for last payroll <Pay Frequency>
    And user opens dropdown list for last payroll
    And user selects Payroll Check option

    Then user opens Edit Check for chosen employee <Given Employee>
    Then user verifies federal taxes <Federal Tax>, <EE OASDI Tax>, <EE Medicare Tax>, <FUI Tax>
    And user verifies state taxes <State Tax>, <SDI Tax>

    Examples:
      |Given Employee|Pay Frequency|Federal Tax|EE OASDI Tax|EE Medicare Tax|FUI Tax|State Tax|SDI Tax|
      |Brown         |Weekly       |59.06      | 37.20      |  8.70         |36.00  | 11.66  |  7.2   |
      |Black         |Weekly       |35.06      | 24.80      |  5.80         |24.00  | 15.00  |        |
      |Armstrong     |Weekly       |155.38     | 71.54      |  16.73        |69.23  | 80.65  |        |
      |Red           |Weekly       |16.54      | 24.80      |  5.80         |24.00  |        |        |
      |Green         |Weekly       |68.66      | 42.16      |  9.86         |40.80  | 23.65  |        |
      |McDown        |Weekly       |155.38     | 71.54      |  16.73        |69.23  | 22.50  | 5.42   |
      |Yellow        |Weekly       |20.00      | 37.20      |  8.70         |36.00  | 29.70  |        |
      |Purple        |Weekly       |90.73      | 53.32      |  12.47        |51.60  |        |        |
      |Douglass      |Weekly       |82.81      | 71.54      |  16.73        |69.23  | 30.80  |        |
      |White         |Weekly       |66.26      | 40.92      |  9.57         |39.60  | 17.82  |        |

