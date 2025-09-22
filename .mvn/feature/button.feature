Feature: LeafGround button page functionality


  @checkbox
  Scenario: Click and confirm title
    Given user launch the application
    And User navigated to the button page
    And User clicks the Click button
    And User should see the page title as Expected Title
    And The Disabled button should be disabled
    And User should see the position of the Submit button
    And User should see the Save button color
    And User should see the height and width of the Submit button
    And User hovers on the Success button
    And User clicks the Image button
    And User should see the total number of rounded buttons