@Search
Feature: Simple search

  Scenario Outline: Search results be displayed when performing a search
    Given I navigate to the start page
    When I search for '<search_string>'
    Then there are search results

  Examples: Search strings
    | search_string |
    | cucumber      |
    | webdriver     |
