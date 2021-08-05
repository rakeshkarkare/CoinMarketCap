Feature: Frontend Task

  @frontend_task1 @regression
  Scenario: User click on show rows dropdown button to verify 100 rows
    Given User launch Coin Market Page
    When User select Shows rows drop down to 100 value
    Then User Verify that 100 rows are getting displayed on page

  @frontend_task2 @regression
  Scenario: Verify filter records based on Price and Market cap ranges
    Given User launch Coin Market Page
    And User clicks on filter button
    When User filter the market cap between $1,000,000,000 and $10,000,000,000
    When User filter the currencies by price between $100 and $300
    Then Verify that the page should display the currencies with the price between 100 and 300
    Then Verify that the page should display market cap between 1,000,000,000 and 10,000,000,000
