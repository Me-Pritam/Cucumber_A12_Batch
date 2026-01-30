Feature: SignUp Functionality


    Background:
        Given The user is on empty browser
        When The user has entered "https://www.demoblaze.com/"

    Scenario: Login with Valid Credintials
        And The user has entered the "demomail123@gmail.com" and "Password@1234"
        Then The SignIn should be successful

    Scenario: Login with Invalid Credintials
        And The user has entered the "demomail121#.com" and "Password  1234"
        Then The SignIn should be unsuccessful

