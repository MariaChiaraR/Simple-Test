Feature: F1

  @TestCaseKey=PROG-T4
  Scenario Outline: Test 3
    Given user is on home page
    When user click on page name from list
    Then user is on selected "<page>" with "<item>"
    Examples:
      | page | item |
      | add | Add Button |
      | add | Add Button |