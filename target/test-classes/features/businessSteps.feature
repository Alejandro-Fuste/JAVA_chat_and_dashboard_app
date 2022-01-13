Feature Businesses being able to sell a portion of their company

  Scenario: As a new Business, I can create a Business profile
    Given The user is on the signup page
    When The user enters their first name
    When The user enters their last name
    When The user enters their business name
    When The user enters their username
    When The user enters their password
    When The user clicks on drop down list
    When The user clicks on Business
    When The user clicks on the submit profile button
    Then The user is redirected to the home page

  Scenario: As a business, I want to sign in
    Given The user is on the home page
    When The user enters their username
    When The user enters their password
    When The user clicks on the login button
    Then The business is redirected to the business page

  Scenario:  As a business, I want to log out
    Given The business is on the business page
    When The business clicks log out
    Then The user is redirected to the home page

  Scenario: As a business, I want to make a comment
    Given The business is on the business page
    When The business clicks on the comment button
    When The business clicks on the down arrow
    When The business clicks on the recipient
    When The business enters a date
    When The business enters a comment
    When The business clicks send
    Then A message saying comment post was successful appears

  Scenario:  As a business, I want to accept an offer
    Given The business is on the business page
    When The business clicks the accept bid button
    Then Message appears saying Accepted

  Scenario:  As a business, I want to view all of my investment comments
    Given The business is on the business page
    Then A table opens up and the information is shown

  Scenario:  As a business, I want to view all of my view original pitch
    Given The business is on the business page
    Then The table autopopulates

    Scenario:  As a business, I want to create a pitch
      Given The business is on the business page
      When The business clicks the create pitch button
      When The business enters the date
      When The business enters their amount
      When The business enters their percentage
      When The business enters their pitch
      When The business clicks submit
      Then A message says Pitch offer was created


