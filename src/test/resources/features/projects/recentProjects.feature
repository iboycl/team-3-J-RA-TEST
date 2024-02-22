@Projects
  Feature: Get Recent Projects

    Scenario: Validate get recent projects
      When I send a get request to projects endpoint
      Then Response should contain the last projects