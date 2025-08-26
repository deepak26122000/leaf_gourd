Feature: Leaf ground basic authentication

  @textbox
  Scenario: Valid Credentials
    Given User on Auth page
    When User click on Home
    And User click on basic auth

  @textbox
  Scenario: User is on Dashboard
    Given User Enter Url
    When User click on Browser
    And Click on Alert popup
    Then User Handle the popup

  @textbox
  Scenario: Fill textboxes using data from Excel
    Given User Click on element
    When User enters in the Name field
    And User appends country to the City field
    And User verify the text box
    And  User clear the text box
    And User retrieve typed text
    And User types email and presses Tab
    And User types about in the About Yourself field
    And User enter the press
    And User Click and Confirm Label Position Changes
    And User enters dob in the DOB field
    And User enters number in the Number spinner
    And User enters slider in the Slider field
    Then Click and Confirm Keyboard appears

