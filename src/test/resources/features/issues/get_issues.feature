@issues @endToEnd
Feature: Validate get issue

  @positiveTest  @GET
  Scenario: Validate get issue
    When I send a GET request to issue endpoint
    Then Response status code should be 200
    And The response contain id number as "10179"

  @negativeTest @GET
  Scenario: Validate error message for invalid key
    When The user sends get request with invalid key as "SCRUM-190"
    Then The response status code should be 404
    And Error message must be "[Issue does not exist or you do not have permission to see it.]"



