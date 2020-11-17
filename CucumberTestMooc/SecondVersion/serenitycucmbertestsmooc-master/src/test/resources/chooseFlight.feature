Feature:
  Choose Feature http://blazedemo.com

  Scenario Outline: Positive test
    Given user opens the site
    When user choose departure city
    And user clicks on ChooseFlight button
    Then user sees Flight list
    And departure city should be displayed

    Examples:
    | departure city |
    | Philadelphia |
    | Boston |