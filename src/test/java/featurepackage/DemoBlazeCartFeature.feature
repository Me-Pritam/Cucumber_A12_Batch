@System
Feature:Cart




    @EmptyItem
    Scenario: Veiw Empty Cart
        Given The User is present on the DemoBlaze HomePage
        When The User clicks on the Cart Link
        Then The Cart Page should be displayed
        And The Cart should be empty

    @OneItem
    Scenario: View Cart After Adding One Item
        When The User adds one item to cart
        And The User clicks on the Cart Link
        Then The Cart Page should be displayed
        And The Product should be visible in the Cart

    @OneItem
    Scenario: View Cart After Adding Two Items
        When The User adds two items to cart
        And The User clicks on the Cart Link
        Then The Cart Page should be displayed
        And The Two Products should be visible in the Cart

