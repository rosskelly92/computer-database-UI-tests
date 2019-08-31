@regression
Feature: Create
  Verifying the functionality for adding a new computer

  Background: Initialise base page and navigate to base url
    Given I load the HomePage

  @smoke @update @TC011
  Scenario: Update a computer
    Given I add a new computer with all fields populated
    When I update the computer
    Then the update message reads "Done! Computer " computer name " has been updated"

  @smoke @read @update @TC011
  Scenario: Updated computer cannot be retrieved via the original details
    Given I add a new computer with all fields populated
    And I update the computer
    When I search for the original computer
    Then there are no search results

  @smoke @read @update @TC011
  Scenario: Edited Computer details are displayed correctly in table and edit mode
    Given I add a new computer with all fields populated
    And I update the computer
    When I search for the updated computer
    Then updated values are displayed in the table
    And updated values are displayed in edit mode

  @update @TC012 @wip
  Scenario: Cannot save an update with empty name field
    Given I add a new computer with all fields populated
    When I update the computer to remove name
    Then I receive an update validation warning
    And I can proceed with update upon filling the field
    And the update message reads "Done! Computer " computer name " has been updated"