Feature: Add attachment to issue

  Background:
    Given The user has Authentication and ready to connect

  Scenario Outline: Test add attachment to issue method functionality with valid issue id
    When The user sends POST request to add attachment endpoint to specified issue id as <key> with png file
    Then The status code should be <statusCode>
    And The attachment id should not be empty or null
    And The response creation date must be the same with the date of creation date
    Examples:
      | key         | statusCode |
      | "SCRUM-187" | 200        |

  Scenario Outline: Test add attachment to issue method functionality with invalid issue key
    When The user sends POST request to add attachment endpoint with invalid <invalidIssueKey> key with txt file
    Then The status code should be <statusCode>
    Examples:
      | invalidIssueKey | statusCode |
      | "NanS-6289"     | 404        |