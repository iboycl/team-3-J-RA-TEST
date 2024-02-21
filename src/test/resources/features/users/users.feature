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
