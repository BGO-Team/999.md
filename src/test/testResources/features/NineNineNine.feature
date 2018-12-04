#noinspection NonAsciiCharacters
Feature: Vadim's Features

  @Vadim @Login
  Scenario: Log in
    Given user is on "HomePage"
    When user click on "Log In" button
    And user fill in Login and Password Input field and click Submit
    Then User Name is showing on Top Bar

  @Vadim @Language
  Scenario: Change Language
    Given user is on "HomePage"
    When user change language
    Then language was changed on "Romanian"

  @Vadim @Language
  Scenario: Double change Language
    Given user is on "HomePage"
    When user change language
    And user change language
    Then language was changed on "Russian"

  @Vadim @AccessToProduct
  Scenario Outline: Access to Product using Categories
    Given user is on "HomePage"
    When user click on "<category>" category
    And user click on "<subCategory>" sub-category
    And user click on "<product>" product
    Then user is on this product
    Examples:
    | category    | subCategory          | product |
#    | Random      | Random               | Random  |
    | Транспорт   | Легковые автомобили  | Random  |
    | Недвижимость| Дома и дачи          | Random  |

  @Vadim @AddToFavorite
  Scenario Outline: Add Product to favorite
    Given user is on "HomePage"
    When user click on "Log In" button
    And user fill in Login and Password Input field and click Submit
    When user click on "<category>" category
    And user click on "<subCategory>" sub-category
    And user click on "Random" product
    And user add product to Favorite List
    And user go to FavoritesPage
    Then product is in Favorite List
    Examples:
    | category         | subCategory        |
    | Транспорт        | Велотранспорт      |
    | Телефоны и связь | Мобильные телефоны |
