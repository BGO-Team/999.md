Feature:Andrew's features

  Background:
    Given user is on "HomePage"

  @Test @asecu @T11
  Scenario Outline: Add <FirstName> <LastName> valid details in the system
    When user navigates to "TopBar"
    And user clicks on "loginButton"
    Then a login frame is displayed
    And "First" user confirm Login and Password
    Then "First" User Name is shown on Top Bar
    When user navigates to "TopBar"
    And  user clicks on "settingsButton"
    Then a settings frame is opened
    When user inserts "<FirstName>" and "<LastName>"
    And insert the folowing "<dd>" "<mm>" "<yyyy>" birth details
    And set the gender to "<gender>"
    And user clicks on "saveButton"
    Then The data is saved
    Examples:
      | FirstName | LastName | gender | yyyy | mm | dd |
      | Andrei    | Secu     | male   | 1990 | 11 | 11 |
#      | Elena     | Avram    | female | 2018 | 4  | 3  |

  @Test @asecu @T12 @Login1
  Scenario Outline: Add invalid <Context> user details in the system
    When user navigates to "TopBar"
    And user clicks on "loginButton"
    Then a login frame is displayed
    And "First" user confirm Login and Password
    Then "First" User Name is shown on Top Bar
    And user navigates to "TopBar"
    And  user clicks on "settingsButton"
    Then a settings frame is opened
    When user inserts "<FirstName>" and "<LastName>"
    And insert the folowing "<dd>" "<mm>" "<yyyy>" birth details
    And set the gender to "<gender>"
    And user clicks on "saveButton"
    Then new details are not saved
    Examples:
      | Context    | FirstName | LastName | gender | yyyy | mm | dd |
      | Gender     | Vitalie   | Boghian  | herzon | 1990 | 2  | 30 |
#      | Birth Date | Ion       | Vasile   | male   | 1990 | 2  | 30 |
#      | Birth Date | Maria     | Pojoga   | female | 2018 | 12 | 30 |
#      | Birth Date | Nicu      | Elvoir   | female | 2018 | 12 | 7  |
#      |            |           |          |        | 1990 | 2  | 30 |
#      | Fisrt Name | #$&%@$%&  | Secu     | male   | 1998 | 11 | 13 |
#      | Last Name  | Gicu      | ##@$#    | male   | 1995 | 10 | 11 |

  @Test @asecu @T21
  Scenario Outline: Search for an existent <SearchText> item
    When user navigates to "TopBar"
    And user clicks on "loginButton"
    Then a login frame is displayed
    And "First" user confirm Login and Password
    Then "First" User Name is shown on Top Bar
    When user navigate to header
    And user clicks on "searchField"
    And inserts "<SearchText>"
    And user clicks on "searchButton"
    Then a new ProductList page is displayed
    When user navigate to a "Random" product
    Then a new product page window is displayed
    Then Product Name or Product description contains "<SearchText>"
    Examples:
      | SearchText     |
      | telefon  mobil |
      | Mercedes       |
#      | inel           |
#      | stare buna     |
#      | haine          |
#      | samsung        |
#      | apple          |

  @Test @asecu @T22
  Scenario Outline: Search for a white space item
    When user navigate to header
    And user clicks on "searchField"
    And inserts "<SearchText>"
    And user clicks on "searchButton"
    Then user remains on HomePage
    Examples:
      | SearchText |
      |            |

  @Test @asecu @T23
  Scenario Outline: Search for a product that does not exist in the system space item
    When user navigates to "TopBar"
    And user clicks on "loginButton"
    Then a login frame is displayed
    And "First" user confirm Login and Password
    Then "First" User Name is shown on Top Bar
    When user navigate to header
    And user clicks on "searchField"
    And inserts "<SearchText>"
    And user clicks on "searchButton"
    Then a new ProductList page is displayed
    And no products was found
    Examples:
      | SearchText       |
      | 312rwsdfa4343wef |
#      | yugy6fuyrdufi7t  |


  @Test @asecu @T31
  Scenario Outline: Login and Filter <context> by <filtredProperty>
    When user navigates to "TopBar"
    And user clicks on "loginButton"
    And "First" user confirm Login and Password
    Then "First" User Name is shown on Top Bar
    When user click on "<categoryName>" category
    Then user is on selected category page
    When user click on "<sub-categotyName>" sub-category
    Then selected sub-category is displayed
    When user select "<filtredProperty>" filter name
    And click on "<propertyValue>" property value
    Then The page is updated
    When user click on "Random" product
    Then the value of "<filtredProperty>" property is "<propertyValue>"
    Examples:
      | context | categoryName       | sub-categotyName    | filtredProperty      | propertyValue |
      | Car     | Транспорт          | Легковые автомобили | количество мест      | 5             |
#      | Car     | Транспорт          | Легковые автомобили | состояние            | Без пробега   |
#      | Phone   | Телефоны и связь   | Мобильные телефоны  | Состояние            | Б\У           |
#      | Phone   | Телефоны и связь   | Мобильные телефоны  | Операционная система | Android       |
#      | Phone   | Телефоны и связь   | Мобильные телефоны  | Встроенная память    | 64 Gb         |
#      | Animals | Питомцы и растения | Кошки               | Пол                  | Кот           |
#      | Animals | Питомцы и растения | Птицы               | Возраст              | Детеныш       |
#      | Animals | Питомцы и растения | Собаки              | Размер               | Средняя       |

