Feature: Get Project
  Background:
    Given The user has Authentication and ready to connect

  Scenario: User gets project with a valid key
    When The user sends get request to the Get Project endpoint with "SCRUM" key
    Then The response status code should be 200
    And The time should be under 2000 ms on the response
    And The project name text should  be "Scrum Projem"

  Scenario: User gets project with an invalid key
    When The user sends get request to the Get Project endpoint with "Mehmet" key
    Then The response status code should be 404
    And The time should be under 2000 ms on the response

