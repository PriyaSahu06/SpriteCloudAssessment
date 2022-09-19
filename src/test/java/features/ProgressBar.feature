#**************************************************************************
#Author: Priya Sahu
#Last updated: 14/09/2022
#Description: Feature file for ProgressBar : Check Progress Bar and stop at 75%
#**************************************************************************

Feature: UI Test validation
  As a customer I want to validate UI test scenarios for given website

  Background:
    Given I am on the home page

  @testUI
  Scenario: As a Customer I validate Progress Bar
    When I navigate to ProgressBar
    And I click on start
    And I check on progressBar and click stop
    Then I validate result label

