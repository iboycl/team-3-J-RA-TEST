@issues @endToEnd
Feature: Delete issue

  Background:
    Given The user has Authentication and ready to connect

  @DELETE
  Scenario Outline: Test delete issue method functionality
    When The user sends DELETE request to the delete issue endpoint with issue id as <id>
    Then The status code should be <statusCode>
    Examples:
      | id          | statusCode |
      | "SCRUM-247" | 204        |



