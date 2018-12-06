Feature: Corneliu's Features

  @Corneliu @User @Sc1
  Scenario: Verify user-detailes information
    Given user is on "HomePage"
    When user clicks on "loginButton"
    And "Second" user confirm Login and Password
    When user go to the TopBar
    And  user clicks on "settingsButton"
    Then a settings frame is opened
    Then user verify his detailes


  @Corneliu @AddNews @Sc2
  Scenario: Create a new news with accessories for telephone category
    Given user is on "HomePage"
    And user clicks on "loginButton"
    And "Second" user confirm Login and Password
    When user is on Add a new news page
    And user add a new news
    Then user verify if his news is displayed in My News Page

  @Corneliu @Message @Sc3
  Scenario Outline: Write a new message on created news
    Given user is on "HomePage"
    And user clicks on "loginButton"
    And "First" user confirm Login and Password
    And user navigate to header
    When user clicks on "searchField"
    And user search the news "<newsName>"
    And user clicks on "searchButton"
    And user click on news "<newsName>"
    And user sent "<message>" to product's author

    Examples:
      | newsName        | message                                     |
      | Sell iphone 999 | Hello, how much it cost?                    |
      | Sell iphone 99  | Hi, it is a real iphone?                    |
      | Sell iphone 9   | Salut, dar tu stii ca nu exista asa iphone? |