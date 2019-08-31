@smoke
Feature: SmokeTest
  Testing the core CRUD functions

  Background: Tests start from the homepage
    Given I load the HomePage

  @smoke @create
  Scenario: Add a new computer with minimum mandatory data
    When I add a new computer with only name field populated
    Then the save message reads "Done! Computer " computer name " has been created"

  @smoke @create
  Scenario: Add a new computer with all possible data
    When I add a new computer with all fields populated
    Then the save message reads "Done! Computer " computer name " has been created"

  @smoke @update
  Scenario: Update a computer
    Given I add a new computer with all fields populated
    When I update the computer
    Then the update message reads "Done! Computer " computer name " has been updated"

  @smoke @delete
  Scenario: Delete a computer
    Given I add a new computer with all fields populated
    When I delete the computer
    Then the delete message reads "Done! Computer has been deleted"

  @smoke @delete @wip
  Scenario: Deleted computer cannot be retrieved
    Given I have deleted a computer
    When I search for the deleted computer
    Then there are no search results

  @smoke @read
  Scenario: Computer details are displayed correctly in table and edit mode
    Given I add a new computer with all fields populated
    When I search for the computer
    Then correct values are displayed in the table
    And correct values are displayed in edit mode

  @smoke @read
  Scenario: Edited Computer details are displayed correctly in table and edit mode
    Given I add a new computer with all fields populated
    And I update the computer
    When I search for the updated computer
    Then updated values are displayed in the table
    And updated values are displayed in edit mode