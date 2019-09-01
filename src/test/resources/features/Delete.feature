@regression
Feature: Create
  Verifying the functionality for adding a new computer

  Background: Initialise base page and navigate to base url
    Given I load the HomePage

  @smoke @delete @TC017
  Scenario: Delete a computer
    Given I add a new computer with all fields populated
    When I delete the computer
    Then the delete message reads "Done! Computer has been deleted"

  @smoke @delete @TC017
  Scenario: Deleted computer cannot be retrieved
    Given I have deleted a computer
    When I search for the deleted computer
    Then there are no search results

  @delete @TC018
  Scenario: Delete a duplicate computer
    Given I have 2 identical computers
    When I delete the computer
    And I search for the computer
    Then correct values are displayed in the table

  @delete @TC019 @bug @ignore @incomplete
  Scenario: Navigate back to a deleted computer
    Given I have deleted a computer
    When I navigate back to the computer
    And I click create
    Then it is handled gracefully