Feature: Full Checkbox Interaction on Leafground
  @checkbox
  Scenario: Interact with all checkbox types on the Leafground page
    Given User click on the element
    When user click on basic check box
    And User click on the notification checkbox
    And User select favorite languages
    And User click on Tri State Checkbox
    And User toggle the switch control
    And User Verify check box is disabled
    Then User select multiple cities