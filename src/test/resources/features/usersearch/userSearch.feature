@userSearch @endToEnd
Feature: Validate User Search Procedure

  Background:
    Given The user has Authentication and ready to connect

  @positiveTest @GET
  Scenario Outline: Validate user search
    When I send a GET request to user search endpoint with "<queryParam>"
    Then The response status code should be <statusCode>
    And The response should show right user with "<displayName>" "<locale>" "<message>"

    Examples:
      | queryParam | statusCode | displayName   | locale | message                          |
      | ibrahim    | 200        | ibrahim       | en_US  |                                  |
      | mehmet     | 200        | Mehmet BİLGİÇ | tr_TR  |                                  |
      |            | 400        |               |        | query parameter must be provided |

  @negativeTest @GET
  Scenario: Validate user search without authorization
    When I send a GET request to user search endpoint without authorization
    Then The response status code should be 401
    And The response should contain the "error"