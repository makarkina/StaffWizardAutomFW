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
    Then user verifies federal taxes <Federal Tax>, <EE OASDI Tax>, <EE Medicare Tax>, <FUI Tax>
    And user verifies state taxes <State Tax>, <SDI Tax>

    Examples:
     | Given Employee |Federal Tax|EE OASDI Tax|EE Medicare Tax|FUI Tax|State Tax|SDI Tax|Local Tax|
     | Douglass       | 121.53    | 62.00      |  14.50        |60.00  | 37.00   |       |         |
     | Douglass       | 121.53    | 62.00      |  14.50        |60.00  | 37.00   |       |         |
