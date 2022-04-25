Feature: Add address

  Scenario Outline: Add new address
    Given user is logged in on mystore page
    When user click Create new address
    When user fills New Address form with data "<alias>", "<address>", "<city>", "<postal code>","<phone>"
    And click Save button to add first address
    Then first address is added
    #And the data is validated
    And the address is removed
    And checks if address is removed



    Examples:
      |alias    |address       |city        |postal code  |   phone|
      |Mike     |Jerozolimskie |Warsaw      |01-591       |0700 251 241|
     #|BigTom   | Central Park | New Jersey | BZ5YH       |001 258 658
     #|Michal   |Mickiewicza   |Wroclaw     | 71-410      | 695809805

  # C:\Users\micha\OneDrive\Pulpit\Tester Oprogramowania\Automatyzujący\CodersLab\Zadania_zaliczeniowe\src\test\java\ZadaniaZaliczeniowe
  # znqocowprtbwttvupo@nvhrw.com
  # wertyq1