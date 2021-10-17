Feature:
  Choose Feature https://dev.vgroll.com/

  Background:
    Given user opens the application
    And user login using anna and 234
    And user selects Payrolls mode on Main page

  Scenario Outline: Positive test

    And user selects payroll with <Given Check date>

    Examples:
      |Given Check date|
      |07/18/2033      |






