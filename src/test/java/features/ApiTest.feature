#**************************************************************************
#Author: Priya
#Last updated: 14/09/2022
#Description: Feature file for Api test : various APIs
#**************************************************************************



Feature: API Test validation
  As a customer I want to validate API test scenarios for given website


  @testAPI
  Scenario Outline: As a Customer I test API /pet
    Given the pet endpoint exists
    When I send a valid add pet payload with name <name> and photoUrl <photoUrl>
    Then response status code should be <responseCode>
    And add pet response should be valid
    Examples:
      |name | photoUrl | responseCode|
      |"name"| null      | 200         |
      |"name"| "photo"      | 200         |


  @testAPI
  Scenario Outline: As a Customer I test API /store/order
    Given the pet endpoint exists
    When I send a valid add pet payload with name <name> and photoUrl <photoUrl>
    Then response status code should be <responseCode>
    And add pet response should be valid
    When the order endpoint exists
    And I send a valid order payload
    Then response status code should be 200
    And order response should be valid
    Examples:
      |name | photoUrl | responseCode|
      |"name"| null      | 200         |
      |"name"| "photo"      | 200         |


  @testAPI
  Scenario Outline: As a Customer I test API /store/order/{orderId}
    Given the pet endpoint exists
    When I send a valid add pet payload with name <name> and photoUrl <photoUrl>
    Then response status code should be <responseCode>
    And add pet response should be valid
    When the order endpoint exists
    And I send a valid order payload
    Then response status code should be 200
    And order response should be valid
    When the delete order endpoint exists
    And I send a delete order request
    Then response status code should be 200
    Examples:
      |name | photoUrl | responseCode|
      |"name"| null      | 200         |
      |"name"| "photo"      | 200         |




