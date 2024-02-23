@issueAttachments @endToEnd
Feature: Delete issue

  Background:
    Given The user has Authentication and ready to connect
    When The user sends POST request to add attachment endpoint to specified issue id as "SCRUM-187" with png file

  @DELETE
  Scenario Outline: Test delete attachment method functionality with attachment id
    When The user sends DELETE request to delete attachment endpoint with attachment id
    Then The status code should be <statusCode>
    Examples:
      | statusCode |
      | 204        |
