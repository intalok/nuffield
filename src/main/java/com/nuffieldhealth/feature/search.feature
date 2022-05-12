Feature: Search the near by Gym

  @smoke
  Scenario: Find the nearest Gym based on the zip code
    Given Open chrome browser
    When  open the nuffield health url
    Then  enter the zipcode "E14 8AY"
    Then  verify the nearest gym address