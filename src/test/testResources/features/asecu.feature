Feature:Andrew's features

  @Test @asecu1
  Scenario: test scenario
    Given user is on "HomePage"
    When user click on "loginButton" button
    Then a new pop up window is displayed
    When user confirm Login and Password
    Then User Name is showing on Top Bar




  @Test @asecu
  Scenario: Access any product
    Given user is on "HomePage"
    When user click on "Random" category
    Then user is on a category page
    When user click on "Random" sub-category
    Then user is on a cateogry page
    When user click on "Random" product
    Then user is on this product


  @TestB @asecu
  Scenario Outline:  Add valid user firstName, lastName and gender details
    Given user is on "HomePage"
    When user click on "Log In" button
    Then a new pop up window is displayed
    When user fill in Login and Password Input field and click Submit
    Then User Name is showing on Top Bar
    When user click on "settingsButton" buttons
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


  @TestB @asecu
  Scenario Outline: Add invalid user firstName, lastName and gender details
    Given user is on "HomePage"
    When user click on "Log In" button
    Then a new pop up window is displayed
    When user fill in Login and Password Input field and click Submit
    Then User Name is showing on Top Bar
    When user click on "Settings" button
    Then a settings frame is opened
    When user inserts "<FirstName>" and "<LastName>"
#    And insert the folowing 12 11 1997 birth details
    And set the gender to "<gender>"
    And click on save button
    Then new details are not saved
    Examples:
      | FirstName | LastName | gender |
      | #$&%@$%&  | Secu     | masde  |
      | Boris     | ##@$#    | hain   |
      | 34234     | %$W$24   | femse  |
