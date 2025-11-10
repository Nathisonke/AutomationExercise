Feature: Product Search and Add to Cart
  As a registered user
  I want to search for products and add them to the cart
  So that I can verify the e-commerce flow works correctly

  Background:
    Given user is on the home page

  @ProductSearch
  Scenario: Search for a product and add it to the cart
    When user clicks on the "Products" link
    And user enters "dress" in the search box
    And user clicks the search button
    Then search results for "dress" are displayed
    When user adds the first product to the cart
    Then the product should be successfully added to the cart
