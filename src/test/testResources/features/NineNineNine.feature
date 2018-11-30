Feature: Vadim's Features

  @Vadim
  Scenario: Log in
    Given user is on "HomePage"
    When user click on "Log In" button
    And user fill in Login and Password Input field and click Submit
    Then User Name is showing on Top Bar

  @Vadim
  Scenario: Change Language
  Given user is on "HomePage"
  When user change language
  Then language was changed on "Romanian"

  @Vadim @Run
  Scenario: Access to Product using Categories
    Given user is on "HomePage"
    When user click on "Random" category
    And user click on "Random" sub-category
    And user click on "Random" product
    Then user is on this product
