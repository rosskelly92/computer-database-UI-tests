@regression
Feature: Create
  Verifying the functionality for updating computers

  Background: Initialise base page and navigate to base url
    Given I load the HomePage

  @smoke @update @TC011
  Scenario: 01 - Update a computer
    Given I add a new computer with all fields populated
    When I update the computer
    Then the update message reads "Done! Computer " computer name " has been updated"

  @smoke @read @update @TC011
  Scenario: 02 - Updated computer cannot be retrieved via the original details
    Given I add a new computer with all fields populated
    And I update the computer
    When I search for the original computer
    Then there are no search results

  @smoke @read @update @TC011
  Scenario: 03 - Edited Computer details are displayed correctly in table and edit mode
    Given I add a new computer with all fields populated
    And I update the computer
    When I search for the updated computer
    Then updated values are displayed in the table
    And updated values are displayed in edit mode

  @update @TC012
  Scenario: 04 - Cannot save an update with empty name field
    Given I add a new computer with all fields populated
    When I update the computer to remove name
    Then I receive an update validation warning
    And I can proceed with update upon filling the field
    And the update message reads "Done! Computer " computer name " has been updated"

  @update @TC008
  Scenario: 05 - Update name only computer to have additional fields
    Given I add a new computer with only name field populated
    When I update the computer
    And I search for the updated computer
    Then updated values are displayed in the table

  @update @TC009
  Scenario: 06 - Update name only computer to a new name
    Given I add a new computer with only name field populated
    When I update the name only
    And I search for the updated computer
    Then only the name is updated in the table

  @update @TC010
  Scenario: 07 - Update computer to remove all non mandatory information
    Given I add a new computer with all fields populated
    When I update to remove non mandatory fields
    And I search for the computer
    Then the table shows non mandatory fields as empty

  @update @TC016
  Scenario: 08 - Cancel an update - verify original preserved
    Given I add a new computer with all fields populated
    When I cancel an update
    And I search for the original computer
    Then correct values are displayed in the table

  @update @TC016
  Scenario: 09 - Cancel an update - verify update not applied
    Given I add a new computer with all fields populated
    When I cancel an update
    And I search for the updated computer
    Then there are no search results

  @update @TC013 @bug @B002
  Scenario Outline: 10 - Add computer - date validation on Introduced field
    When I attempt to update a computer with Introduced date "<intro>"
    Then I receive an update validation warning
    Examples:
      | intro |
      | 2019-01-00 |
      | 2019-01-32 |
      | 2019-02-29 |
      | 2019-13-01 |
      | 2019-00-01 |
      | 2019-01--01 |
      | 2019--01-01 |
      | 2019.01.01  |
      | 2019 01 01  |
      | 01-01-2019  |
      | 01 Jan 2019 |

  @update @TC014 @bug @B002
  Scenario Outline: 11 - Add computer - date validation on Discontinued field
    When I attempt to update a computer with Discontinued date "<discont>"
    Then I receive an update validation warning
    Examples:
      | discont |
      | 2019-01-00 |
      | 2019-01-32 |
      | 2019-02-29 |
      | 2019-13-01 |
      | 2019-00-01 |
      | 2019-01--01 |
      | 2019--01-01 |
      | 2019.01.01  |
      | 2019 01 01  |
      | 01-01-2019  |
      | 01 Jan 2019 |

  @update @TC015 @bug @B004
  Scenario: 12 - edit mode - special characters in Name field
    When I update a computer to have special characters in the name
    And I search for the special computer
    Then The special computer is displayed in results