Feature: Does GitHub work fine?

  Scenario: Contact Sales tab should be enabled

    Given Open GitHub page
    When Click Contact Sales button
    Then Contact Sales form should be visible

  Scenario: Features tab should be enabled

    Given Open GitHub page
    When Open Features tab
    Then Features tab should be visible