Feature: Checkout Process
  As a user
  I want to complete a checkout after adding items to the cart
  So that I can verify the purchase workflow works correctly

  Background:
    Given user is on the home page

  @Checkout
  Scenario: User proceeds to checkout successfully
    When user clicks on the "Products" link
    And user enters "dress" in the search box
    And user clicks the search button
    And user adds the first product to the cart
    And user clicks on the "Cart" link
    And user proceeds to checkout
    And user logs in with valid credentials "testuser@example.com" and "password123"
    Then the checkout page is displayed
