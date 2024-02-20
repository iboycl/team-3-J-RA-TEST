@User
  Feature: Validate User Procedures

    Scenario: Validate get all users
      When I send a GET request to users endpoint
      Then I get all users