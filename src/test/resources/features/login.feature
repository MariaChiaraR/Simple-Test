Feature: F1

  @TestCaseKey=PROG-T3
  Scenario Outline: Test 3
    Given user is on home page
    When user click on "<page>" name from list
    Then user is on selected "<page>" with "<item>"
    Examples:
      | page | item |
      | page 2 | item 1 |
      | page 3 | item 3 |