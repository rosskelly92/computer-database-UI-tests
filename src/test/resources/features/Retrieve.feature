@regression
Feature: Create
  Verifying the retrieval and display of computers, including filter, sort and pagination

  Background: Initialise base page and navigate to base url
    Given I load the HomePage

  @retrieve @TC020
  Scenario: On page 1 of search results, Previous button is disabled
    Then previous button is disabled

  @retrieve @TC020
  Scenario: Navigation between pages of search results
    When I click next page
    Then I am on the second page of results
    And I can navigate back to the first page

  @retrieve @TC020 @flaky
  Scenario: Correct number of search results retrieved
    Given I have 4 identical computers
    When I search for the computer
    Then there are 4 search results
    And previous button is disabled
    And next button is disabled

  @retrieve @TC021
  Scenario: Clear filter returns all results
    Given I add a new computer with all fields populated
    When I search for the computer
    And clear the filter
    Then all results are displayed

  @retrieve @TC022
  Scenario: Change filter criteria
    Given I add multiple unique computers
    When I search for the computer
    And I search for the updated computer
    Then values from the second filter are displayed in the table

  @retrieve @TC020 @bug @B005 @ignore
  Scenario: Search results span multiple pages
    Given I have 11 identical computers
    When I search for the computer
    And I click next page
    Then next button is disabled
    And pagination text reads "Displaying 11 to 11 of 11"
    And the search results read "11 computers found"

  @retrieve @TC023 @bug @B003 @ignore
  Scenario Outline: Verify Sort Order
    Given I search for "b"
    When I apply "<order>" sort order to "<column>"
    Then the values are displayed in "<order>" order of "<column>"
    Examples:
    | column | order |
    | Computer name | ascending |
    | Computer name | descending |
    | Introduced | ascending |
    | Introduced | descending |
    | Discontinued | ascending |
    | Discontinued | descending |
    | Company | ascending |
    | Company | descending |
