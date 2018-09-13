Feature: Does Service work fine?

  Scenario: Service should return successful response

    When Send request
    Then Verify returned data is correct