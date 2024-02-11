Feature: Add a pet to the catalogue

  This feature verifies pets can be added to the catalogue

  @pet @API @POST
  Scenario Outline: Verify pet can be added to the catalogue successfully when required data is provided
    Given The POST pet API can be hit
    When I add a pet to the catalogue with "<petId>" and "<petName>" and "<status>" and "<categoryId>" and "<categoryName>" and "<tagId>" and "<tagName>"
    Then the pet is added to the catalogue successfully with "<petId>" and "<petName>" and "<status>" and "<categoryId>" and "<categoryName>" and "<tagId>" and "<tagName>"
    Examples:
      | petId | petName                           | status    | categoryId | categoryName | tagId | tagName |
      | 111   | pug                               | available | 001        | pug          | 001   | pugTag1 |
      | 222   | goldenR                           | sold      | 002        | sporting     | 002   | grTag2  |
      | 333   |                                   | pending   | 003        |              | 003   | grTag3  |
      | 444   | aVeryVeryVeryVeryVeryVeryLongName | available | 004        |              | 004   | grTag4  |

  @pet @API @POST
  Scenario: Verify pet can be added to the catalogue successfully when required data is provided
    Given The POST pet API can be hit
    When I add a pet to the catalogue with empty payload
    Then the pet is added to the catalogue successfully with an Id

  @pet @API @POST
  Scenario Outline: Verify relevant errors are generated when required data is missing
    Given The POST pet API can be hit
    When I add a pet to the catalogue with no payload
    Then send an error with "<ErrorCode>"
    Examples:
      | ErrorCode |
      | 405       |

  @pet @API @POST
  Scenario Outline: Verify relevant errors are generated when required data is missing
    Given The POST pet API can be hit
    When I add a pet to the catalogue with no header
    Then send an error with "<ErrorCode>"
    Examples:
      | ErrorCode |
      | 415       |