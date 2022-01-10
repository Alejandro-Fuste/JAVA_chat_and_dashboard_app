Feature: Shark should be able to interact with potential investments

  Scenario: Shark can create a shark profile
    Given The user is on the home page
    When The user clicks on the new shark profile button
    When The user clicks on drop down list
    When The user clicks on Shark
    When The user enters their first name
    When The user enters their last name
    When The user enters their username
    When The user enters their password
    When The user re-enters their password
    When The user clicks on the create profile button
    Then A message saying shark profile created successfully appears

  Scenario: Shark logs in to their account
    Given The user is on the home page
    When The user enters their username
    When The user enters their password
    When The user clicks on drop down list
    When The user clicks on Shark
    When The user clicks on the shark login button
    Then The shark should be redirected to the shark page

  Scenario: Shark can view investment pitches
    Given The shark is on the shark page
    When The sharks clicks on view pitches button
    Then A table with the investment pitches is rendered

  Scenario: Shark can make a comment about the pitch
    Given The shark is on the shark page
    When The sharks clicks on view pitches button
    When The shark enters the business ID
    When The shark enters the pitch ID
    When The shark enters their shark ID
    When The shark enters a comment
    When The shark clicks on the comment post button
    Then A message saying comment post was successful appears

  Scenario: Shark can make an offer on a pitch
    Given The shark is on the shark page
    When The sharks clicks on view pitches button
    When The shark enters the pitch ID
    When The shark enters an amount
    When The shark enters a percentage
    When The shark clicks on the offer post button
    Then A message saying offer post was successful appears

  Scenario: Shark can accept a pitch
    Given The shark is on the shark page
    When The sharks clicks on view pitches button
    When The shark clicks on the accept button
    Then A message saying deal is closed appears

  Scenario: Shark can log out
    Given The shark is on the shark page
    When The shark clicks on the logout button
    Then The user should be redirected to home page