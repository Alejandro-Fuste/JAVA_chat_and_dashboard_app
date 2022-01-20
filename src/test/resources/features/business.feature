Feature:  Business Logging

  Scenario: As a new business, I want to create a new profile
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
    When The user enters their login password
    When The user clicks on drop down list
    When The user clicks on Business
    When The user clicks on the login button
    Then The business is redirected to the business page

  Scenario: As a business, I want to leave a comment with a shark on a pitch
    Given The business is on the business page
    When The business clicks on the comment button
    When The comment modal is displayed
    When The business clicks on drop down list
    When The business clicks on the recipient
    When The business enters a date
    When The business enters a comment
    When The business clicks send
    When A message saying comment post was successful appears
    Then The business clicks the close button

  Scenario:  As a business, I want to accept new bids
    Given The business is on the business page
    When The business clicks on the open accept modal
    When The business clicks the accept bid button
    Then The business clicks on the accept pitch close button

  Scenario:  As a business, I want to view all of my investment current requests
    Given The business is on the business page
    Then A table opens up and the information is shown

  Scenario:  As a business, I want to view all comments
    Given The business is on the business page
    Then A table opens up and the information is shown

  Scenario: As a business, I want to log out
    Given The business is on the business page
    When The business clicks log out
    Then The user should be redirected to the home page
