Feature: Vadim's Features

  @Vadim
  Scenario: Log in
    Given user is on "Home Page"
    When user click on "Log In" button
    And user fill in Login and Password Input field and click Submit
    Then User Name is showing on Top Bar

  @Vadim @Run
  Scenario: Change Language
  Given user is on "Home Page"
  When user change language
  Then language was changed on "Romanian"
