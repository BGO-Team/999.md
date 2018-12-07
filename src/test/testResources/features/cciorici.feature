Feature: Corneliu's Features

  @Corneliu @User @Sc1
  Scenario: Verify user-detailes information
    Given user is on "HomePage"
    And user clicks on "loginButton"
    And "Second" user confirm Login and Password
    When user go to the TopBar
    And  user clicks on "settingsButton"
    And a settings frame is opened
    Then user verify his details


  @Corneliu @AddNews @Sc2
  Scenario: Create a new news with accessories for telephone category
    Given user is on "HomePage"
    And user clicks on "loginButton"
    And "Second" user confirm Login and Password
    When user is on Add a new news page
    And user add a new news
    Then user verify if his news is displayed in My News Page


  @Corneliu @Message @Sc3
  Scenario Outline: Write a new message about product
    Given user is on "HomePage"
    When user clicks on "loginButton"
    And "First" user confirm Login and Password
    Then "First" User Name is showing on Top Bar
    When user navigate to header
    And user clicks on "searchField"
    And inserts "<newsName>"
    And user clicks on "searchButton"
    And user click on news with name "<newsName>"
    And user sent "<message>" to product's author
    Then the notification that message was sent appeared
    When user go to the TopBar
    When user clicks on "messagesButton"
    And user go to the ChatFrame
    And user clicks on "sentMessage"
    Then user verify the sent "<message>"

    Examples:
      | newsName                            | message                                |
      | Iphone 5s 16Gb 500lei.Icloud curat. | Hello, it is original?                 |
      | Bmw e 60 ideal 35 euro              | Salut, dar cit costa chiria pe o luna? |