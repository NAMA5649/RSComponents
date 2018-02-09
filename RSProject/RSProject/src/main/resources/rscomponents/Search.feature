Feature: Product Search

  Scenario: Appling search filter for Auto recloser
    Given I navigate to rsonline website
    When I select Automation & Gear control and select circuit protection & circuit breakers
    And Apply the filters for supply voltage
    Then verify the applied filter products are displayed

  Scenario: Appling multiple search filter for AV Mixed cable
    Given I navigate to rsonline website
    When I select Cables & wires and select Audio video cable
    And Apply multiple filters for Connector
    Then verify the applied filter products are displayed for AV mixed cable

  Scenario: Search the product and select item
    Given I navigate to rsonline website
    When Enter the product name in search box
    Then Verify the search page
