Feature: This is a "log in" feature checks if I am able to log in with correct email & password

  Scenario: Log in scenario
  	Given I am on the main page
    And I click on the log in page
    When I put email and password
      | Fields   | Value                 |
      | EMAIL    | skrzypiec.t@gmail.com |
      | PASSWORD | password123           |
    Then I should be on my account page
