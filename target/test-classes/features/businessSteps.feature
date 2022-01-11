Feature Businesses being able to sell a portion of their company

  Scenario:  As a new business, I want to create a new profile
    Given The user is on the log in page
    When The user clicks create new account button
    Then The user can create his own account

  Scenario: As a business, I want to sign in
    Given The user is on the home page
    When The user enters their username
    When The user enters their password
    When The user clicks submit
    Then They are transferred to the business page

  Scenario:  As a business, I want to log out
    Given The user is logged in
    When The user clicks log out
    Then They are transferred back to the log in page

  Scenario: As a business, I want to post an investment price
    Given The user on the bidding page
    When The user enters a price into the asking price
    When The user clicks submit
    Then The table is updated to show the new asking price

  Scenario:  As a business, I want to accept new bids
    Given The user is on the bidding page
    When The user clicks the accept bid button
    Then The user is redirected to the Terms and Conditions Page

  Scenario: As a business, I want to leave a comment with a shark on a pitch
    Given The user is currently on the bidding page
    When The user enters text into the comment box
    When The user clicks submit
    Then The comment is posted on the table

  Scenario:  As a business, I want to view all of my investment current requests
    Given The user is logged in
    When The user clicks the view current requests button
    Then A table opens up and the information is shown

  Scenario:  As a business, I want to view all of my past requests
    Given The user is logged in
    When The user clicks on the view all past requests button
    Then The user is shown all of his past denied requests
