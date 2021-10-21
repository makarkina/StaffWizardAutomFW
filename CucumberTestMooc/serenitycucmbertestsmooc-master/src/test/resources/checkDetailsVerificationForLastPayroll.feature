Feature:
  Choose Feature https://dev.vgroll.com/

  Background:
    Given user opens the application
    And user login using admin@testcompany and 123
    When user selects Payrolls mode on Main page


  Scenario Outline: verification of earning details for last payroll

    Then user gets last payroll date
    And user verifies a pay frequency for last payroll <Pay Frequency>
    And user opens dropdown list for last payroll
    And user selects Payroll Check option

    Then user opens Edit Check for chosen employee <Given Employee>
    And user clicks Payroll Check Details Tab

    Then user opens Edit Payroll Check for given ED <Earning>
    And user verifies earning for <Given Employee>, <Earning>, <State>, <Hours>, <Pay Rate>, <Amount>

    Examples:
      |Pay Frequency|Given Employee |Earning       |State|Hours   |Pay Rate |Amount    |
      |Weekly       |Brown          |Regular hours |CA   |40.00   |15.00    |600.00    |
      |Weekly       |Armstrong      |Salary        |CT   |        |         |1153.85   |


