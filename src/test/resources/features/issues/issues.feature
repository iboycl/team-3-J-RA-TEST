@Issues
  Feature: Issue Procedures

    Scenario: Validate creation of an issue

      When I set the request body for creating a new issue
        | projectKey         | TEAM-3                                  |
        | summary            | TEAM-3 This is the summary of the issue |
        | labels             | TEAM-3;POST;CREATE                      |
        | descriptionType    | doc                                     |
        | descriptionVersion | 1                                       |
        | contentType        | 1                                       |