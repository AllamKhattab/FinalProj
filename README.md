
# DemoBlaze Automation Testing Project

This project automates testing for the **DemoBlaze** website using **Selenium**, **Cucumber**, and **TestNG**. It covers scenarios such as user signup, login, adding products to the cart, and completing a purchase, using **Behavior-Driven Development (BDD)**.

## Table of Contents
- [Project Description](#project-description)
- [Tools & Technologies](#tools-and-technologies)
- [Setup Instructions](#setup-instructions)
- [Running the Tests](#running-the-tests)
- [Test Scenarios](#test-scenarios)
- [Code Explanation](#code-explanation)

## Project Description
This project automates user interactions on the **DemoBlaze** website. The primary functionality being tested includes:

- User sign-up and login
- Adding products to the shopping cart
- Completing a purchase
- Verifying the correct display of product titles and prices in the cart

The tests are written using **Cucumber** for BDD and executed with **Selenium WebDriver** to automate the browser interactions.

## Tools & Technologies

The following tools and technologies are used in this project:

- **Java**: Programming language for test scripts.
- **Selenium WebDriver**: Tool for automating web browser interactions.
- **Cucumber**: For BDD-style testing using `.feature` files.
- **TestNG**: Testing framework used to run the Cucumber tests.
- **Maven**: Build automation tool to manage dependencies and test execution.
- **ExtentReports**: For generating detailed test execution reports.

## Setup Instructions

### Prerequisites
1. **Java** (JDK 23 or higher) installed on your system.
2. **Maven** installed on your system.
3. **IDE** (**IntelliJ IDEA**) to edit and run the code.

### Steps to Set Up

1. Clone the repository to your local machine.
2. Install the required dependencies using Maven:
    ```bash
    mvn clean install
    ```

### Browser Driver Setup

Make sure you have the appropriate WebDriver for the browser you wish to run tests on. For example:

- **Chrome**:
- **Edge**: 
- **Firefox**:


### Running the Tests

1. To run all tests:
   ```bash
   mvn test
   ```
2. To run specific scenarios, use Cucumber tags. For example, to run tests tagged with `@Smoke_Testing`:
   ```bash
   mvn test -Dcucumber.options="--tags @Smoke_Testing"

   ```
3. Once tests are completed, view the test execution report located at:
   ```
   target/cucumber-html-report/index.html
   ```

## Test Scenarios

### 1. Verify User Sign-Up

- Navigate to the DemoBlaze homepage.
- Click on the "Sign up" button and fill out the form with valid credentials.
- Confirm that the success message "Sign up successful" appears.

### 2. Verify User Login

- Click on the "Login" button and fill in valid credentials.
- Ensure that the "Logout" button appears, indicating a successful login.

### 3. Verify Product Purchase

- Log in to the system.
- Add two products from the "Laptops" category to the cart.
- Verify that both products are added to the cart.
- Proceed to checkout and fill out the purchase form.
- Verify that the message "Thank you for your purchase!" appears.

### 4. Verify Total Amount Calculation

- Add products to the cart.
- Ensure the total amount displayed is correct.
- Verify that the total matches the cart page and the checkout page.

## Code Explanation

### 1. **Hooks.java**

This class sets up and tears down the browser for each test scenario:
- `@Before`: Opens the browser before each scenario.
- `@After`: Closes the browser after each scenario.

### 2. **Step Definitions (e.g., TC01_signUpSteps.java)**

Each class in the `stepDefs` package defines the steps for a specific test scenario. For example, in `TC01_signUpSteps.java`, the steps to fill the sign-up form, click the button, and validate the success message are implemented.

### 3. **TestRunner.java**

This class is used to run the Cucumber tests with TestNG. It specifies the feature files and step definitions to be used during test execution.

### 4. **POM (pom.xml)**

The `pom.xml` file contains project dependencies, including:
- Selenium WebDriver
- Cucumber
- TestNG
- ExtentReports for reporting

