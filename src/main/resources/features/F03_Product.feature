Feature: F03_ Product | users can add product
  @Smoke_Testing
  Scenario: Verify that user can sign up successfully
    #Given Open the browser and goto "https://www.demoblaze.com/index.html"
    When Click on Sign up button in Header.
    And The user fills in their username "Abdallah2025#" and password "123456aA@" in the form fields and The user submits the form.
    Then Validate that successfully message is Sign up successful.





  @Smoke_Testing
  Scenario: Verify that two products are purchased successfully

# 1-Login
# Given I am on the home page
When I click on the Login button in the header
  And I fill in the login form with username "Abdallah2025#" and password "123456aA@"
    Then I should see that my account is opened successfully
  # 2-Add the first item
  Given Click on Laptops in categories in home page.
    When choose product 1
      And Click on Add to cart button.
        Then Validate that product is successfully added.
    # 3-Add the second item
    Given Click on Laptops in categories in home page.
      When choose product 2
        And Click on Add to cart button.
          Then Validate that product is successfully added.

      Given Click on Cart button in header.
        Then Validate that two products which include title and Price are successfully added in products page.
          And Validate that total amount is calculated correctly.

    Given Click on Place holder button
      Then Validate that total amount is calculated correctly in place holder page.

   When Filling Name"Abdallah", Country"Egypt", City"Cairo", Credit Cart"Visa", Month"12" and Year"27"
    And Click on Purchase button in place holder Form.
     Then Validate that ‘Thank you for your purchase!’ should be displayed.