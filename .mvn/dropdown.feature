Feature: Automation for Dropdown Course Selection

  @sanity
  Scenario: User selects tool, country, city, course, and language
    Given click on the element
    When click on the dropdown
    And  select your favorite UI Automation tool
    And Choose your preferred country
    And Confirm Cities belongs to Country is loaded
    And Choose the Course
    And Choose language randomly
    Then Select Two irrespective of the language chosen

