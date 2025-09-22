Feature: Dynamic Waits

  @checkbox
  Scenario: Handle element waits
    Given User click on element
    When Click on waits
    And User check for visibility
    And User check for invisibility
    And User wait for clickability
    Then User wait for text change
