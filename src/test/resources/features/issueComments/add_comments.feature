Feature: Add Comment

  Background:
    Given The user has Authentication and ready to connect

  Scenario:
    When the user sends  GET request to Add Comments endpoint with specific key as "SCRUM-202"
    Then The response status code should be 201
    And the response text should be "Sayar comments for the project"



  Scenario:
    When the user sends  GET request to Add Comments endpoint with specific key as "SCRUM-12000"
    Then The response status code should be 404


