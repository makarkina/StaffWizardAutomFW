Feature:
  Choose Feature https://dev.vgroll.com/

  Background:
    Given user opens the application
    And user login using anna and 234
    And user selects Payrolls mode on Main page

  Scenario: Payroll creation for one employee for a given pay frequency

    When user gets dates for last payroll
    Then user creates new payroll for given dates
    And user saves new payroll
    And user refreshes Payroll screen

    Then user gets dates for new payroll
    And user gets pay frequency

    Then user verifies day difference between new payroll and previous one
    And user verifies Period Begin Date for new payroll
    And user verifies Period End Date for new payroll


