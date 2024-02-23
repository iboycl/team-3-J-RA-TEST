@issueComments @endToEnd
Feature: Get Comment

  Background:
    Given The user has Authentication and ready to connect

  Scenario: Validate functionality of get comment request with valid issue key and id
  @positiveTest @GET
  Scenario:Validate the user GET a comment with valid response text
    When The user sends get request to the Get Comment endpoint with specific key as "SCRUM-173" and specific id as "10090"
    Then The response status code should be 200
    And The Time should be under 6000 ms on the response
    And The response text should be "Cetınkaya"

  Scenario: Validate functionality of get comment request with valid issue key and id
  @positiveTest @GET
  Scenario:Validate the user GET a comment with valid response
    When The user sends get request to the Get Comment endpoint with specific key as "SCRUM-173" and specific id as "10090"
    Then The response status code should be 200
    And The id should not be null and empty on the response

  Scenario: Validate functionality of get comment request with valid issue key and invalid id
  @negativeTest @GET
  Scenario: the user  GET an invalid comment
    When The user sends get request to the Get Comment endpoint with specific key as "SCRUM-173" and invalid id as "abcd"
    Then The response status code should be 404
    And The user should receive an error message as "null for uri"