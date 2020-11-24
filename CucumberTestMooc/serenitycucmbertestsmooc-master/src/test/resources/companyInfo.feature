Feature:
  Choose Feature http://blazedemo.com

  Scenario: Positive test
    Given user opens the application
    And user login using user and 123
    When user selects Company mode on main page
    And user adds a new company
    And user select Company on company page
    Then user verifies Company Name

