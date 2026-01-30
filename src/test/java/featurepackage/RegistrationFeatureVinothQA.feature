Feature: Registration Feature
    Scenario: Perform Registration using valid data
        Given the user is on the Registration Page
        When the user enters all valid data
            | firstName | John      |
            | lastName  | Doe       |
            | gender    | Female    |
            | course    | TestNG    |
            | street    | 20/1      |
            | aptNum    | 20        |
            | state     | Telangana |
            | city      | Hyderabad |
            | zip       | 500060    |
            | country   | India     |

        Then the Registration should be successful