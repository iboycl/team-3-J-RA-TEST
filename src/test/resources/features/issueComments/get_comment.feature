@issueComments @endToEnd
Feature: Get Comment

  Background:
    Given The user has Authentication and ready to connect


  @positiveTest @GET
  Scenario: Validate functionality of get comment request with valid issue key and id
    When The user sends get request to the Get Comment endpoint with specific key as "SCRUM-173" and specific id as "10090"
    Then The response status code should be 200
    And The Time should be under 6000 ms on the response
    And The response text should be "Cetınkaya"


  @positiveTest @GET
  Scenario: Validate functionality of get comment request with valid issue key and id
    When The user sends get request to the Get Comment endpoint with specific key as "SCRUM-173" and specific id as "10090"
    Then The response status code should be 200
    And The id should not be null and empty on the response

  @negativeTest @GET
  Scenario: Validate functionality of get comment request with valid issue key and invalid id
    When The user sends get request to the Get Comment endpoint with specific key as "SCRUM-173" and invalid id as "abcd"
    Then The response status code should be 404
    And The user should receive an error message as "null for uri"