@regression
Feature: Create
  Verifying the functionality for adding a new computer

  Background: Initialise base page and navigate to base url
    Given I load the HomePage

  @smoke @create @TC002
  Scenario: Add a new computer with minimum mandatory data
    When I add a new computer with only name field populated
    Then the save message reads "Done! Computer " computer name " has been created"

  @smoke @create @TC001
  Scenario: Add a new computer with all possible data
    When I add a new computer with all fields populated
    Then the save message reads "Done! Computer " computer name " has been created"

  @smoke @read @TC001
  Scenario: Computer details are displayed correctly in table and edit mode
    Given I add a new computer with all fields populated
    When I search for the computer
    Then correct values are displayed in the table
    And correct values are displayed in edit mode

  @create @TC003
  Scenario: Cannot add a computer without a name field
    When I save a new computer without name
    Then I receive a validation warning
    And I can proceed upon filling the field
    And the save message reads "Done! Computer " computer name " has been created"

  @create @TC007
  Scenario: Cancel addition
    When I cancel a new computer addition
    And I search for the computer
    Then there are no search results

  @create @TC004 @bug @B002
  Scenario Outline: Add computer - date validation on Introduced field
    When I attempt to add a computer with Introduced date "<intro>"
    Then I receive a validation warning
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

  @create @TC005 @bug @B002
  Scenario Outline: Add computer - date validation on Discontinued field
    When I attempt to add a computer with Discontinued date "<discont>"
    Then I receive a validation warning
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

  @create @TC006 @bug @B004
  Scenario: add mode - special characters in Name field
    When I add a computer with special characters in the name
    And I search for the special computer
    Then The special computer is displayed in results
    # issue with % as a special character in search results, has been removed from this test until requirement clarified