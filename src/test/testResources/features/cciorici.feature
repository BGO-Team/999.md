Feature: Corneliu's Features

  @Corneliu @User @Sc1 @Test
  Scenario: Verify user-detailes information
    Given user is on "HomePage"
    When user navigates to "TopBar"
    And user clicks on "loginButton"
    And "Second" user confirm Login and Password
    Then "Second" User Name is shown on Top Bar
    When user navigates to "TopBar"
    And  user clicks on "settingsButton"
    And a settings frame is opened
    Then user verify his details


  @Corneliu @AddNews @Sc2 @Test
  Scenario Outline: Create a new post with accessories for telephone
    Given user is on "HomePage"
    When user navigates to "TopBar"
    And user clicks on "loginButton"
    And "Second" user confirm Login and Password
    Then "Second" User Name is shown on Top Bar
    When user navigate to header
    And user clicks on "addPostButton"
    And user choose the Category "<Category>" "<urlContains1>"
    And user choose the SubCategory "<SubCategory>" "<urlContains2>"
    And user choose the SellType "<SellType>"
    And user choose the Country "<Country>"
    And user choose Negotiable Price
    And user fill Title field
    And user fill Information field
    And user choose that he is agree with rules
    And user submit new post
    When user navigate to header
    And user clicks on "myPosts"
    Then user verify if his post is displayed in My Posts Page

    Examples:
      | Category         | SubCategory | SellType | Country | urlContains2  | urlContains1            |
      | Телефоны и связь | Аксессуары  | Random   | Random  | 2Faccessories | phone-and-communication |

  @Corneliu @Message @Sc3 @Test
  Scenario Outline: Write a new message to owner's post
    Given user is on "HomePage"
    When user navigates to "TopBar"
    And user clicks on "loginButton"
    And "First" user confirm Login and Password
    Then "First" User Name is shown on Top Bar
    When user navigate to header
    And user clicks on "searchField"
    And inserts "<postName>"
    And user clicks on "searchButton"
    When a new ProductList page is displayed
    And user navigate to a "Random" product
    And a new product page window is displayed
    And user Write "<message>" to owner's post
    Then user clicks on submit message button
    When user navigates to "TopBar"
    And user clicks on message button
    And user navigates to "ChatFrame"
    And user clicks on "sentMessage"
    Then user verify the sent "<message>"

    Examples:
      | postName | message                    |
      | Iphone   | Ultimul pret?              |
      | Bmw      | Salut, dar e buna masina ? |