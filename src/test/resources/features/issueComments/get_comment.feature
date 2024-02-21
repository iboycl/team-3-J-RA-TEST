Feature: Get Comment

  Background:
    Given The user has Base URI and Authentication

  Scenario:
    When The user sends get request to the Get Comment endpoint
    Then The status code should be 200
    And The Time should be under 1000 ms on the response

  Scenario:
    When The user sends get request to the Get Comment endpoint
    Then The status code should be 200
    And The id should not be null and empty on the response

  Scenario:
    When The user sends get request to the Get Comment endpoint with invalid "id"
    Then The status code should be 404
    And The user should receive an error message
