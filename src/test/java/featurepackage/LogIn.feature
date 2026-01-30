Feature: Login Functionality

    Scenario: Login with valid credentials
        Given the user is on the Demoblaze login page
        When the user logs in with the following valid credentials
            | username              | password       |
            | demomail12@gmail.com  | Password@1234  |
        Then the user should be logged in successfully