Feature: This is a "check item price" feature checks if the total price with shipping is correct

  Scenario: Check Item Price 
    Given I am on the main page
    When I click on Blouse category
    When I find more information on specific item
    And  I add quantity and pick a size
    And I add an item to cart
    Then I check if the Total price with shipping is correct

