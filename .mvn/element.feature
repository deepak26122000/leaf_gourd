Feature: LeafGround button page functionality

  Background:
    Given user launch the application
    And User navigated to the button page

@smoke
  Scenario: Click and confirm title
    When User clicks the Click button
    Then User should see the page title as Expected Title
@smoke
    Scenario: Confirm if the button is disabled
      Then The Disabled button should be disabled
  @smoke
  Scenario: Find the position of the Submit button
  Then User should see the position of the Submit button

  @smoke
  Scenario: Find the Save button color
    Then User should see the Save button color

  @smoke
  Scenario: Find the height and width of the Submit button
    Then User should see the height and width of the Submit button

  @smoke
  Scenario: Mouse over and confirm the color changed
    When User hovers on the Success button

  @smoke
  Scenario: Click Image Button and hidden button
    When User clicks the Image button


  @smoke
  Scenario: Find how many rounded buttons are present
    Then User should see the total number of rounded buttons