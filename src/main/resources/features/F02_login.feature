Feature: F02_ login | users could use login functionality to use their accounts

  Scenario: Verify user login successfully
   # Given I am on the home page
    When I click on the Login button in the header
    And I fill in the login form with username "Abda20@" and password "123456aA@"
    Then I should see that my account is opened successfully
