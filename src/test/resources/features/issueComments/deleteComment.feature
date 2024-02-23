@DeleteComment
Feature: Delete Comment

  Background:
    Given The user has Authentication and ready to connect


  Scenario:
    When the user sends  DELETE request to Delete Comments endpoint with specific key as "SCRUM-202" and specific id as "10124"
    Then The response status code should be 204
