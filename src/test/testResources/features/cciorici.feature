Feature: Corneliu's Features

  @Corneliu @User @Sc1
  Scenario: Verify user-detailes information
    Given user is on "HomePage"
    And user clicks on "loginButton"
    And "Second" user confirm Login and Password
    When user navigates to "TopBar"
    And  user clicks on "settingsButton"
    And a settings frame is opened
    Then user verify his details


  @Corneliu @AddNews @Sc2
  Scenario Outline: Create a new post with accessories for telephone
    Given user is on "HomePage"
    And user clicks on "loginButton"
    And "Second" user confirm Login and Password
    When user clicks on "addPostButton"
    And user complete all mandatory fields
    And user inserts "<Category>""<SubCategory>""<SellType>""<Country>"
    And user clicks on "submitPostButton"
    Then user verify if his post is displayed in My Posts Page

    Examples:
      | Category | SubCategory | SellType | Country | urlContains |
      |          |             |          |         |             |

  @Corneliu @Message @Sc3
  Scenario Outline: Write a new message to owner's post
    Given user is on "HomePage"
    When user clicks on "loginButton"
    And "First" user confirm Login and Password
    Then "First" User Name is showing on Top Bar
    When user navigate to header
    And user clicks on "searchField"
    And inserts "<postName>"
    And user clicks on "searchButton"
    And user click on news with name "<postName>"
    And user sent "<message>" to owner's post
    Then the notification that message was sent appeared
    When user navigates to "TopBar"
    When user clicks on "messagesButton"
    And user navigates to "ChatFrame"
    And user clicks on "sentMessage"
    Then user verify the sent "<message>"

    Examples:
      | postName                            | message                                |
      | Iphone 5s 16Gb 500lei.Icloud curat. | Hello, it is original?                 |
      | Bmw e 60 ideal 35 euro              | Salut, dar cit costa chiria pe o luna? |