@regression
Feature: Create
  Verifying the functionality for deleting a computer

  Background: Initialise base page and navigate to base url
    Given I load the HomePage

  @smoke @delete @TC017
  Scenario: 01 - Delete a computer
    Given I add a new computer with all fields populated
    When I delete the computer
    Then the delete message reads "Done! Computer has been deleted"

  @smoke @delete @TC017
  Scenario: 02 - Deleted computer cannot be retrieved
    Given I have deleted a computer
    When I search for the deleted computer
    Then there are no search results

  @delete @TC018
  Scenario: 03 - Delete a duplicate computer
    Given I have 2 identical computers
    When I delete the computer
    And I search for the computer
    Then correct values are displayed in the table

  @delete @TC019 @bug @B001 @ignore @incomplete
  Scenario: 04 - Navigate back to a deleted computer
    Given I have deleted a computer
    When I navigate back to the computer
    And I click create
    Then it is handled gracefully
    # to complete once requirement clarified