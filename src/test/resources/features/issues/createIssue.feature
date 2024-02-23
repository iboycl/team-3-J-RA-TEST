@issues @endToEnd
Feature: Issue Procedures

  Background:
    Given The user has Authentication and ready to connect

  @POST
  Scenario Outline: Validate creation of issue

    When I set the request body for creating a new issue
      | projectKey         | <projectKey>                            |
      | summary            | TEAM-3 This is the summary of the issue |
      | labels             | TEAM-3;POST;CREATE                      |
      | descriptionType    | doc                                     |
      | descriptionVersion | 1                                       |
      | contentType        | paragraph                               |
      | contContentType    | <contContentType>                       |
      | contContentText    | This is the description of the issue    |
      | issueTypeName      | <issueTypeName>                         |

    And I send a POST request to create a new issue
    Then The response status code should be <statusCode>
    And The response should contain right "<message>"

    Examples:

      | statusCode | projectKey | contContentType | issueTypeName | message                           |
      | 201        | SCRUM      | text            | Story         | valid                             |
      | 400        |            | text            | Story         | Specify a valid project ID or key |
      | 400        | SCRUM      |                 | Story         | INVALID_INPUT                     |
      | 400        | SCRUM      | text            |               | Specify an issue type             |

  @negativeTest @POST
  Scenario: Validate unsuccessful creation of issue without authorization
    When I set the request body for creating a new issue
      | projectKey         | SCRUM                                   |
      | summary            | TEAM-3 This is the summary of the issue |
      | labels             | TEAM-3;POST;CREATE                      |
      | descriptionType    | doc                                     |
      | descriptionVersion | 1                                       |
      | contentType        | paragraph                               |
      | contContentType    | text                                    |
      | contContentText    | This is the description of the issue    |
      | issueTypeName      | Story                                   |
    And I send a POST request to create a new issue without authorization
    Then The response status code should be 401
    And The response should contain right "You do not have permission"
