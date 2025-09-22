Feature: Customer Analytics Table
@leafground
  Scenario: Verify customer records by country
    Given User click on the Table
    When User click on Table link
    And User is on Customer Analytics Table page
    Then User searches by country
