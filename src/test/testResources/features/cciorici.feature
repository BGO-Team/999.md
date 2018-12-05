#noinspection NonAsciiCharacters
Feature: NineNineNine's Features

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
      | category     | subCategory         | product |
      | Транспорт    | Легковые автомобили | Random  |
      | Недвижимость | Дома и дачи         | Random  |

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

  @Corneliu @User @Sc1
  Scenario: Verify user-detailes information
    Given user is on "HomePage"
    When user click on "Log In" button
    And user fill in Login and Password Input field as Corneliu and click Submit
    When user is on UserSettings
    Then user verify firstname and lastname
    And user verify email adress

  @Corneliu @AddNews @Sc2
  Scenario: Create a new news with accessories for telephone category
    Given user is on "HomePage"
    When user click on "Log In" button
    And user fill in Login and Password Input field as Corneliu and click Submit
    When user is on Add a new news page
    And user add a new news
    Then User clicked on My News Page
    And user verify if his news is displayed in My News Page

  @Corneliu @Message @Sc3
  Scenario: Write a new message on created news
    Given user is on "HomePage"
    When user click on "Log In" button
    And user fill in Login and Password Input field and click Submit
    And user search the news that was already created
    And user click on news that was already created
    And user sent message to product author