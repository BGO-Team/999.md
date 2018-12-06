Feature: Corneliu's Features

  @Corneliu @User @Sc1
  Scenario: Verify user-detailes information
    Given user is on "HomePage"
    When user click on "loginButton"
    And user fill in Login and Password Input field as Corneliu and click Submit
    When user go to Settings Frame
    Then user verify "firstname" and "lastname" and "email"


  @Corneliu @AddNews @Sc2
  Scenario: Create a new news with accessories for telephone category
    Given user is on "HomePage"
    And user click on "loginButton"
    And user fill in Login and Password Input field as Corneliu and click Submit
    When user is on Add a new news page
    And user add a new news
    Then user verify if his news is displayed in My News Page

  @Corneliu @Message @Sc3
  Scenario Outline: Write a new message on created news
    Given user is on "HomePage"
    And user click on "loginButton"
    And user confirm Login and Password
    And user search the news "<newsName>"
    And user click on news "<newsName>"
    And user sent "<message>" to product's author

    Examples:
      | newsName        | message                                     |
      | Sell iphone 999 | Hello, how much it cost?                    |
      | Sell iphone 99  | Hi, it is a real iphone?                    |
      | Sell iphone 9   | Salut, dar tu stii ca nu exista asa iphone? |