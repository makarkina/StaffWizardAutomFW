Feature:
  Choose Feature http://vgroll.com:8080/vroll/

  Background:
    Given user opens the application
    And user login using admin and 123
    When user selects Company mode on main page


  Scenario: Positive test

    And user selects Employees option on Company page
    Then user selects Payroll checks on Employees page
    And selects Payroll check details on Payroll checks page