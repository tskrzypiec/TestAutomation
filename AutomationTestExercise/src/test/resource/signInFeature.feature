Feature: This is a "sign in" feature checks if I am able to create a new account

  Scenario: Sign in scenario
    Given I am on the main page
    And I click on the sign in page
    When I fill email address
      | Fields | Value                |
      | EMAIL  | tomasz15334@op.pl |
    And I click create an account button
    And I submit the form with valid data
      | Fields        | Value         |
      | Name          | TOMASZ        |
      | SURNAME       | KOWALSKI      |
      | PASSWORD      | password123   |
      | DAYS_VALUE    |            19 |
      | MONTH_VALUE   |             2 |
      | YEAR_VALUE    |          1990 |
      | COMPANY       | SOFLAB        |
      | STREET        | JEROZOLIMSKIE |
      | CITY          | WARSZAWA      |
      | STATE_VALUE   |             2 |
      | ZIP_CODE      |         00023 |
      | COUNTRY_VALUE |            21 |
      | PHONE         |   00574345334 |
      | MOBILE        | 555 666 897   |
    And I set Assign an address alias for future reference field
    And I press Register button
    Then I should be on the Sign in page
