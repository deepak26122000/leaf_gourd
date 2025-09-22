Feature: Validate Radio Button functionality in LeafGround

  @checkbox
  Scenario: Validate all radio button interactions in one flow
    Given user is click on element
    When user click on radio button
    And click on the most fvt browser
    And user click on unselectable
    And user Find the default select radio button
    Then user Select the age group