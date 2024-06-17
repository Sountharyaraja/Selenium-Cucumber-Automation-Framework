Feature: Automate End to End testcase

  Scenario: Login into sauce demo page
    Given user navigates to login page by opening chrome and launch url
    When user enters correct username and password values
    Then user is directed to the homepage
    When click to add to card
    And checkout the product
    And Enter your information and click continue
    And Finish the overview
    And click on back Home
    And logout of the application