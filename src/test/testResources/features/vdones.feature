#noinspection NonAsciiCharacters
Feature: Vadim's Features

  Background:
    Given user is on "HomePage"

  @Vadim @Login
  Scenario: Log in
    When user navigates to "TopBar"
    And user clicks on "loginButton"
    And a login frame is displayed
    And "First" user confirm Login and Password
    Then "First" User Name is shown on Top Bar

  @Vadim @Language
  Scenario: Change Language
    When user navigates to "TopBar"
    And user change language
    Then language was changed on "Romanian"

  @Vadim @Language
  Scenario: Double change Language
    When user navigates to "TopBar"
    And user change language
    And user navigates to "TopBar"
    And user change language
    Then language was changed on "Russian"

  @Vadim @AccessToProduct
  Scenario Outline: Access to Product using Categories
    When user click on "<category>" category
    And user click on "<subCategory>" sub-category
    And user click on "<product>" product
    Then user is on this product
    Examples:
    | category    | subCategory          | product |
    | Транспорт   | Легковые автомобили  | Random  |
    | Недвижимость| Дома и дачи          | Random  |

  @Vadim @AddToFavorite
  Scenario Outline: Add Product to favorite
    When user navigates to "TopBar"
    And user clicks on "loginButton"
    And a login frame is displayed
    And "First" user confirm Login and Password
    And user click on "<category>" category
    And user click on "<subCategory>" sub-category
    And user click on "Random" product
    And user add product to Favorite List
    And user go to FavoritesPage
    Then product is in Favorite List
    Examples:
    | category         | subCategory        |
    | Транспорт        | Велотранспорт      |
    | Телефоны и связь | Мобильные телефоны |