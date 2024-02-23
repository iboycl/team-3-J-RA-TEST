@issues
  Feature: Validate edit issue
    Scenario: Validate send put request
      When I send a PUT request to edit issue endpoint
      Then The response status code should be 400
      Then Error message must be "[No content to map to Object due to end of input]"

      Scenario: : Put request for rename with invalid key
        When I send a PUT request to rename with new body but different key
        Then The response status code should be 404
