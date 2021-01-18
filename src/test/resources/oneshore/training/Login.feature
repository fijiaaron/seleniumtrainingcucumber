
@login
Feature: Login
  I want to access the secure area
  
  @regression
  Scenario: Successful login
    Given I am on the login page
    When I enter my username and password
    Then I should be able to access the secure area
