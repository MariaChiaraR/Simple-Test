Feature: F1

  @ProvaTag
  @TestCaseKey=PROG-T2
  Scenario: Test 2
    Given user is on home page
    When user click on "Selected Page From List" name from list
    Then user is on selected "add" with "Add Button"

  @TestCaseKey=PROG-T5
  Scenario: Test 5
    Given user is on home page
    When user click on page name from list
    Then user is on selected pge

  @Prova
  @TestCaseKey=PROG-T3
  Scenario Outline: Test 3
    Given user is on home page
    When user click on page name from list
    Then user is on selected "<page>" with "<item>"
    Examples:
      | page | item |
      | add | Add Button |
      | add | Add Button |
      | add | Add Button |

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