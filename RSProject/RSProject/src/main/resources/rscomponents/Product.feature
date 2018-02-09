Feature: purchase product

  Scenario: buy audio video connector accesories
    Given I navigate to rsonline website
    When I select Connectors and AudiovideoConnectors accesories
    And I enter the quantity for accesories
    Then I succesfully add item to cart and purchase

  Scenario: buy audio video connector adepters
    Given I navigate to rsonline website
    When I select Connectors and AudiovideoConnectors adepters
    And I enter the quantity for adepters
    Then I succesfully add item to cart and purchase

  Scenario: buy Automative batteries
    Given I navigate to rsonline website
    When I select Batteries and AutomativeBatteries
    And I enter the quantity for AutomativeBatteries
    Then I succesfully add item to cart and purchase
