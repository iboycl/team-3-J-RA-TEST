@Projects
  Feature: Get Recent Projects

    Background:
      Given The user has Authentication and ready to connect

    Scenario: Validate get recent projects
      When I send a get request to projects endpoint
      Then Response should contain the last projects