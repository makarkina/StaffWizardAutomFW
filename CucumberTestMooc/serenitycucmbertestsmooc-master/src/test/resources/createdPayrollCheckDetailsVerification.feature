Feature:
  Choose Feature https://dev.vgroll.com/

  Background:
    Given user opens the application
    And user login using anna and 234
    When user selects Payrolls mode on Main page


  Scenario Outline: Positive test

    Then user selects Payroll with <Given Check date> on Payroll screen
    And user verifies check date for <Given Check date>
    And user selects Payroll Check option

    Then user opens Edit Check for chosen employee <Given Employee>
    And user opens Payroll Check Details

    And user opens Payroll Check Details for given ED <Earning>
    Then user verifies earning for <Given Check date>, <Employee ID>, <Earning>, <State>, <Hours>, <Pay Rate>, <Amount>

    Examples:
      | Given Check date |Given Employee    |Employee ID|Earning |State|Hours   |Pay Rate   |Amount    |
      | 04/14/2032       |Victor Green      |EmpID#6    |Hourly  |OK   |40.00   |15.00      |600.00    |


