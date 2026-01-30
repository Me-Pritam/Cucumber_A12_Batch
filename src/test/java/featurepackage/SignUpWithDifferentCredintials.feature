Feature: SignUp using different Credintials
    Scenario Outline: SignUp with different credintials
        Given the user is on the Demoblaze Home page
        When The user clicks on SignUp
        And The user will SignUp using "<UserName>" and "<Password>"
        Then The SignUp should be successful;
        Examples:
                  |     UserName      |       Password    |
                  |a@mail.com         |Password@1234      |
                  |aa@gmail.com       |Password@4321      |
                  |ab@yahoomail.com   |P@1234567          |