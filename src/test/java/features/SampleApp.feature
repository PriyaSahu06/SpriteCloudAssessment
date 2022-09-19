#**************************************************************************
#Author: Priya Sahu
#Last updated: 14/09/2022
#Description: Feature file for Sample App : For successful login use any non-empty user name and `pwd` as password.
#**************************************************************************

Feature: UI Test validation
  As a customer I want to validate UI test scenarios for given website

  Background:
    Given I am on the home page

  @testUI
  Scenario: As a Customer I validate Sample App
    When I navigate to SampleApp
    And I enter username Abc and password pwd
    Then I should see success message with username Abc

