@projects @endToEnd
Feature: Get Recent Projects

  Background:
    Given The user has Authentication and ready to connect

  @positiveTest @GET
  Scenario: User gets recent projects with valid credentials
    When The user sends get request to the Get Recent Project endpoint
    Then The response status code should be 200
    And The user gets a list of projects

  @positiveTest @GET
  Scenario: User gets recent projects with valid credentials
    When The user sends get request to the Get Recent Project endpoint
    Then The response status code should be 200
    And The time should be under 2000 ms on the response
    And The project name text should be "[Scrum Projem, deneme]" and the other properties as expected



