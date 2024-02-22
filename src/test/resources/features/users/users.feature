@User
  Feature: Validate User Procedures

    Scenario Outline: Validate get all users
      When I send a GET request to users endpoint with "<startAt>" and "<maxResults>"
      Then The response status code should be 200
      And The response should contain <number> users

      Examples:

        | startAt | maxResults | number |
        |         |            | 26     |
        | 0       | 10         | 10     |
        | 16      | 1          | 1      |


    Scenario: Validate get all users
      When I send a GET request to users endpoint
      Then All user informations are true
      And The response status code should be 200

    Scenario: Get all users with wrong endpoint
      When I send a Get request to users with wrong endpoint
      Then Error message should be  "null for uri: https://inaracademygroup3.atlassian.net/rest/api/3/users/searc"
      And The response status code should be 400

