@issueComments @endToEnd
Feature: Add Comment

  Background:
    Given The user has Authentication and ready to connect

  @positiveTest @POST
  Scenario:Test Add Comment with valid key
    When the user sends  GET request to Add Comments endpoint with specific key as "SCRUM-202"
    Then The response status code should be 201
    And the response text should be "Sayar comments for the project"

  @negativeTest @POST
  Scenario:Test Add Comment with Invalid Key
    When the user sends  GET request to Add Comments endpoint with specific key as "SCRUM-12000"
    Then The response status code should be 404


