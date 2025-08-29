Feature: Ebay Home Page Scenarios

  Scenario: User Click the Advanced key button scenario
    Given User On E'bay Page
    When User click on Advanced hyperlink Button
    Then user navigate to advanced Search Page

  Scenario: User searches for the product on eBay
    Given User On E'bay Page
    When User enters "iphone 16 pro max" in the search bar
    And User clicks the search button
    Then User should see 500 search results displayed on the screen

  @Smoke
  Scenario: User searches for the product on eBay2
    Given User On E'bay Page
    When User enters "Gun" in the search bar
    And User clicks the search button
    Then User should see 100 search results displayed on the screen

  @Regression
  Scenario: User searches for the item Category Tab
    Given User On E'bay Page
    When User search the for "Soap" in "Baby" category

  Scenario Outline: User clicks on eBay navigation links
    Given User On E'bay Page
    When User clicks on the "<link>" navigation link
    Then User should be navigated to "<URL>" and the page title should contain "<title>"

    Examples:
      | link            | URL                                                                  | title           |
      | Motors          | https://www.ebay.com/b/Auto-Parts-Accessories/6028/bn_569479         | Auto Parts      |
      | Home & Garden   | https://www.ebay.com/b/Home-Garden/11700/bn_1853126                  | Home & Garden   |
      | Fashion         | https://www.ebay.com/b/Fashion/bn_7000259856                         | Fashion         |
