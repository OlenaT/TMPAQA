Feature: Does Service work fine?

  Scenario: Service should return successful response

    Given I send request to the service
    When I recieve the response
    Then Verify returned temperature is 24.1