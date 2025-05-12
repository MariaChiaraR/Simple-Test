Feature: F2

  @ProvTag
  @TestCaseKey=PROG-T5
  Scenario: Test 5
    Given user is on home page
    When user click on page name from list
    Then user is on selected pge

  @Prova @ProvTag
    @TestCaseKey=PROG-T4
  Scenario Outline:
    Given user is on home page
    When user click on page name from list
    Then user is on selected "<page>" with "<item>"
    Examples:
      | page | item |
      | add | Add Button |
      | add | Add Button |