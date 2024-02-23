@user @endToEnd
Feature: Validate Single User Procedures

  Background:
    Given The user has Authentication and ready to connect

  @positiveTest @GET
  Scenario: Validate get a user
    When I send a Get request user endpoint
    Then User informations are must be true
    And The response status code should be 200

  @negativeTest @GET
  Scenario: Get a user with wrong accountId
    When I send a Get request with wrong accountId
    Then Error message must be  "[Specified user does not exist or you do not have required permissions]"
    And The response status code should be 404