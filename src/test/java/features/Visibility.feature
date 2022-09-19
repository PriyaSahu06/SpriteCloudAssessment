#**************************************************************************
#Author: Priya Sahu
#Last updated: 14/09/2022
#Description: Feature file for Visibility : Check Visibility of Button
#**************************************************************************

Feature: UI Test validation
  As a customer I want to validate UI test scenarios for given website

  Background:
    Given I am on the home page

  @testUI
  Scenario: As a Customer I validate Visibility page
    When I navigate to Visibility page
    And I validate visibility of other buttons:visible
    And I click on hide
    Then I validate visibility of other buttons:invisible

