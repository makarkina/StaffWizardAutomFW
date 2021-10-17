Feature:
  Choose Feature https://dev.vgroll.com/

  Background:
    Given user opens the application
    And user login using admin@testcompany and 123
    When user selects Payrolls mode on Main page


  Scenario Outline: verification of earning details for a payroll on given date

    When user selects payroll with <Given Check date>
    And user verifies a pay frequency for given payroll date <Pay Frequency>
    And user selects Payroll Check option
    And user verifies <Given Check date> on selected check

    Then user opens Edit Check for chosen employee <Given Employee>
    And user clicks Payroll Check Details Tab

    Then user opens Edit Payroll Check for given ED <Earning>
    And user verifies check date for <Given Check date>
    And user verifies earning for <Given Employee>, <Earning>, <State>, <Hours>, <Pay Rate>, <Amount>

    Examples:
      |Pay Frequency  |Given Check date|Given Employee|Earning      |State|Hours   |Pay Rate   |Amount   |
      |Weekly         |05/14/2025      |Armstrong     |Salary       |CT   |        |           |1153.85  |
      |Every Two Weeks|03/14/2025      |Armstrong     |Salary       |CT   |        |           |2307.69  |
      |Monthly        |04/22/2025      |Armstrong     |Salary       |CT   |        |           |5000.00  |
      |Weekly         |04/30/2025      |Green         |Regular hours|AR   |40.00   |15.00      |680.00   |



