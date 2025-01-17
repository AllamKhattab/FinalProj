Feature: F01_ sign up | users could use sign up functionality to create their accounts


  #Positive Scenario
  Scenario: Verify that user can sign up successfully
    #Given Open the browser and goto "https://www.demoblaze.com/index.html"
    When Click on Sign up button in Header.
       And The user fills in their username "Abda20@" and password "123456aA@" in the form fields and The user submits the form.
          Then Validate that successfully message is Sign up successful.


#Negative Scenario
  Scenario Outline: Verify that user can't sign up with invalid data
    #Given Open the browser and goto "https://www.demoblaze.com/index.html"
    When Click on Sign up button in Header.
    And The user fills in their Invalid username "<username>" and password "<password>" in the form fields and The user submits the form.
        Then Validate that Wrong message is "<message>".
    Examples:
      | username            | password      | message                                 |
      | ++++++++++++        | 123456aA@     | This user already exist.                |
      | standard12@         | wrongpass     | This user already exist.                |
      | Abdallssfsah20@     | 123456aA@     | This user already exist.                |
      |                     | 123456aA@     | Please fill out Username and Password.  |
      | Abdallssfsah20@     |               | Please fill out Username and Password.  |
      |                     |               | Please fill out Username and Password.  |
