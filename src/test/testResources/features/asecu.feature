Feature:Andrew's features

#  @Test @asecu
#  Scenario: test scenario
#    Given user is on "HomePage"
#    When user click on "loginButton" button
#    Then a new pop up window is displayed
#    When user confirm Login and Password
#    Then User Name is showing on Top Bar
#
#
#  @Test @asecu
#  Scenario: Access any product
#    Given user is on "HomePage"
#    When user click on "Random" category
#    Then user is on a category page
#    When user click on "Random" sub-category
#    Then user is on a cateogry page
#    When user click on "Random" product
#    Then user is on this product


  @Test @asecu @1
  Scenario Outline: Add <FirstName> <LastName> valid details in the system
    Given user is on "HomePage"
    When user click on "loginButton"
    Then a new pop up window is displayed
    And "First" user confirm Login and Password
    Then "First" User Name is showing on Top Bar
    When user go to the TopBar
    And  user click on "settingsButton"
    Then a settings frame is opened
    When user inserts "<FirstName>" and "<LastName>"
    And insert the folowing "<dd>" "<mm>" "<yyyy>" birth details
    And set the gender to "<gender>"
    And click on save button
    Then The data is saved
    Examples:
      | FirstName | LastName | gender | yyyy | mm | dd |
      | Andrei    | Secu     | male   | 1990 | 11 | 11 |
      | Elena     | Avram    | female | 2018 | 4  | 3  |

  @Test @asecu @asecu1
  Scenario Outline: Add invalid <Context> in the system
    Given user is on "HomePage"
    When user click on "loginButton"
    Then a new pop up window is displayed
    And "First" user confirm Login and Password
    Then "First" User Name is showing on Top Bar
    When user go to the TopBar
    And  user click on "settingsButton"
    Then a settings frame is opened
    When user inserts "<FirstName>" and "<LastName>"
    And insert the folowing "<dd>" "<mm>" "<yyyy>" birth details
    And set the gender to "<gender>"
    And click on save button
    Then new details are not saved
    Examples:
      | Context    | FirstName | LastName | gender | yyyy | mm | dd |
      | Fisrt Name | #$&%@$%&  | Secu     | male   | 1998 | 11 | 13 |
      | Last Name  | Gicu      | ##@$#    | male   | 1995 | 10 | 11 |
      | Gender     | Vitalie   | Boghian  | herzon | 1990 | 2  | 30 |
      | Birth Date | Ion       | Vasile   | male   | 1990 | 2  | 30 |
      | Birth Date | Maria     | Pojoga   | female | 2018 | 12 | 30 |
      | Birth Date | Nicu      | Elvoir   | female | 2018 | 12 | 7  |
      |            |           |          |        | 1990 | 2  | 30 |


#  Scenario Outline: Add <FirstName> <LastName> valid details in the system
#    Given user is on "HomePage"
#    When user go to header
#    Then detect search field
#    When user click on "SearchField"
#    And user enter "<searchData>" into the field
#    Then a new search page is displayed
#    When user fill in Login and Password Input field and click Submit
#    Then User Name is showing on Top Bar
#    When user go to the TopBar
#    And  user click on "settingsButton" button
#    Then a settings frame is opened
#    Examples: