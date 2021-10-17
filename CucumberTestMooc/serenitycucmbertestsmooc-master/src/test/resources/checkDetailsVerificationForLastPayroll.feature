Feature:
  Choose Feature https://dev.vgroll.com/

  Background:
    Given user opens the application
    And user login using admin@testcompany and 123
    When user selects Payrolls mode on Main page


  Scenario Outline: verification of earning details for last payroll

    Then user gets last payroll date
    And user gets pay frequency
    And user opens dropdown list for last payroll
    And user selects Payroll Check option

    Then user opens Edit Check for chosen employee <Given Employee>
    And user clicks Payroll Check Details Tab

    Then user opens Edit Payroll Check for given ED <Earning>
    And user verifies earning for <Employee ID>, <Earning>, <State>, <Hours>, <Pay Rate>, <Amount>


    Examples:
      |Given Employee    |Employee ID|Earning       |State|Hours   |Pay Rate |Amount    |
      |John Brown        |EmpID#1    |Regular hours |CA   |40.00   |15.00    |680       |
      |Louis J Armstrong |EmpID#3    |Salary        |CT   |        |         |1153.85   |


