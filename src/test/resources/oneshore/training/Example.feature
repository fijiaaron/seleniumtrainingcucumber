@PenetrationTest
Feature: FBI Secure Access

As an FBI agent
I want to be able to access the Secure Area
So that I can read classified information

Background:
Given the top secret document is placed in the vault

@AccessGranted, @Smoketest
Scenario: Agent with top secret clearance

Given I have my FBI badge
And I have top secret clearance
When I scan my badge 
Then I should be able to read the top secret document

@AccessDenied, @Regression
Scenario: Agent with limited clearance

Given I have my FBI badge
And I have limited clearance
When I scan my badge
Then I should not be able to read the top secret document

@AccessDenied
Scenario: Not an agent

Given I have a CIA badge
When I scan my badge
Then I should not be ale to read the top secret document

@AccessDenied
Scenario: Agent with top secret clearance but not on duty

Given I have my FBI badge
And I have top secret clearance
But It is outside by hours of service
When I scan my badge 
Then I should not be able to read the top secret document
And it should log my access attempt