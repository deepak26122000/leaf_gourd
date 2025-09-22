Feature: Link Validation on the Application Page

  @checkbox
  Scenario: Validate links on the page
    Given User click on Element
    And User click on HyperLink
    And Take User to dashboard
    And Find User destination
    And Use Checks  is it broken link
    And User Checks is it Duplicate Link
    And User Check Number of Links
    Then User counts Layout links
