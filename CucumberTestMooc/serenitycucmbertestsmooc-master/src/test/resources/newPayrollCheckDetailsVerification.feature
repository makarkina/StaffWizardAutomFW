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
    And user opens new Payroll Check Details on Edit Payroll Check screen
    And user adds new Payroll Check Detail with <Given ED>, <State>, <Hours>, <Pay Rate>
    And user saves new Payroll Check Details

    Then user selects given ED <Given ED>
    And user opens Edit Payroll Check Detail form
    And user verifies added check details for <State>, <Amount>


    Examples:
      |Given Check date|Given Employee       |Given ED      |State|Hours|Pay Rate|Amount|
      | 07/16/2032     |Margaret White       |Overtime      |MO   |5    |20      |150   |

