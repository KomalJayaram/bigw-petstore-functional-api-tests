Feature: Add a pet to the catalogue

  This feature verifies pets can be added to the catalogue

  Scenario Outline: Verify pet can be added to the catalogue
    Given The POST pet API can be hit
    When I add a pet to the catalogue with "<petId>" and "<petName>" and "<status>" and "<categoryId>" and "<categoryName>" and "<tagId>" and "<tagName>"
    Then the pet is added to the catalogue successfully with "<petId>" and "<petName>" and "<status>" and "<categoryId>" and "<categoryName>" and "<tagId>" and "<tagName>"
    Examples:
      | petId | petName | status    | categoryId | categoryName | tagId | tagName |
      | 111   | pug     | available | 001        | pug          | 001   | pugTag1 |
      | 222   | goldenR | sold      | 002        | sporting     | 002   | grTag2  |