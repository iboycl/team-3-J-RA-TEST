Feature: Update Comment

  Background:
    Given The user has Authentication and ready to connect

  Scenario: Validate functionality of update comment request with valid issue key and id
    When The user sends PUT request to the Update Comment endpoint with specific issue key "SCRUM-205" and comment id as "10127"
    Then The response status code should be 200
    And The Time should be under 6000 ms on the response

  Scenario: Validate functionality of update comment request with valid issue key and id
    When The user sends PUT request to the Update Comment endpoint with specific issue key "SCRUM-205" and comment id as "10127"
    Then The response status code should be 200
    And The content of request should match with the content of the response


  Scenario: Validate functionality of update comment request with valid issue key and invalid id
    When The user sends PUT request to the Update Comment endpoint with specific issue key "SCRUM-205" and invalid comment id as "1234567"
    Then The response status code should be 404
    And The error message should be displayed