@UserSearch
Feature: Validate User Search Procedure

  Background:
    Given The user has Authentication and ready to connect

  Scenario Outline: Validate user search
    When I send a GET request to user search endpoint with "<queryParam>"
    Then The response status code should be <statusCode>
    And The response should show right user with "<displayName>" "<accountID>" "<message>"

    Examples:
      | queryParam | statusCode | displayName   | accountID                                   | message                          |
      | ibo        | 200        | ibrahim       | 6287a5d4f0302e0068bfbb2a                    |                                  |
      | mehmet     | 200        | Mehmet BİLGİÇ | 712020:a45a425e-2989-4425-b569-dda696c73fa4 |                                  |
      |            | 400        |               |                                             | query parameter must be provided |

  Scenario: Validate user search without authorization
    When I send a GET request to user search endpoint without authorization
    Then The response status code should be 401
    And The response should contain the "error"