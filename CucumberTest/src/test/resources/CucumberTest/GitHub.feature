Feature: Does GitHub work fine?

  Scenario: Contact Sales tab should be enabled

    Given Open GitHub page
    When Click Contact Sales button
    Then Contact Sales form title should be "Contact our Sales Team"

  Scenario: Features tab should be enabled

    Given Open GitHub page
    When Open Features tab
    Then Features tab title should be "How developers work"

  Scenario: Business tab should be enabled

    Given Open GitHub page
    When Open Business tab
    Then Business tab title should be "Bring GitHub to work"