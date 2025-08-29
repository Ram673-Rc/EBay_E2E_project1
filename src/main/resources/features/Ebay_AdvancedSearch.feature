Feature: Ebay Advanced Search logo Page

  @P1 @P2
  Scenario: Ebay Logo on Advanced Search Page
    Given User Ebay Advanced Search Page
    When User click the Ebay logo
    Then User Back to the Ebay Home page



 Scenario: Advanced Search a item in Ebay
Given  User Ebay Advanced Search Page
When User Search the items
  | Keyword       | Exclude | Min Price | Max Price |
  | iPhone 16 Pro | case    | 500       | 1500      |
Then User Back to the Ebay Home page
 