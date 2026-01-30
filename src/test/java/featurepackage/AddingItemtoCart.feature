Feature: Adding Item to Cart
    Scenario: Add Samsung Galaxy S6 to cart
        Given the user is present on the Demoblaze Home page
        When the user do valid login
            * the user opens the Phone Category
            * the user selects "Samsung galaxy s6"
            * the user adds the mobile To Cart
            * the user goes to Cart
        Then the mobile should be visible in cart