Feature: Does Google work fine?

  Scenario: Google should search for Cucumber

    Given Open Google search page
    When Search for "Cucumber"
    Then I should see search results "Приблизна кількість результатів: 120 000 000 (0,42 сек.)"