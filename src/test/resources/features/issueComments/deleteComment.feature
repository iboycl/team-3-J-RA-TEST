@issueComments @endToEnd
Feature: Delete Comment

  Background:
    Given The user has Authentication and ready to connect

  @DELETE
  Scenario:Test add attachment to issue method functionality with valid issue id
    When the user sends  DELETE request to Delete Comments endpoint with specific key as "SCRUM-202" and specific id as "10124"
    Then The response status code should be 204
