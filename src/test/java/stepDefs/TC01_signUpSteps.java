package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TC01_signUp;

import java.time.Duration;

public class TC01_signUpSteps {
TC01_signUp signUp=new TC01_signUp();



    // Todo:Positive Scenario
    @When("Click on Sign up button in Header.")
    public void user_Press_On_Sign_up_button() {
        signUp.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        signUp.SignUpButton_Homepage().click();
    }
    @And("The user fills in their username {string} and password {string} in the form fields and The user submits the form.")
    public void User_Enter_Valid_data(String username,String password) {
        signUp.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        signUp.userName().sendKeys(username);
        signUp.Password().sendKeys(password);
        signUp.SignUpButton_SignUpPage().click();
    }
    @Then("Validate that successfully message is Sign up successful.")
    public void successfully_message() {
        SoftAssert softAssert=new SoftAssert();
        WebDriverWait wait = new WebDriverWait(signUp.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
       String ExpectedResult="Sign up successful.";
        String ActualResult=signUp.driver.switchTo().alert().getText();
        softAssert.assertEquals(ExpectedResult,ActualResult);
        softAssert.assertAll();
        signUp.driver.switchTo().alert().accept();
    }

    // Todo:Negative Scenario
    @And("The user fills in their Invalid username {string} and password {string} in the form fields and The user submits the form.")
    public void User_Enter_InValid_data(String username,String password) {
        signUp.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        signUp.userName().sendKeys(username);
        signUp.Password().sendKeys(password);
        signUp.SignUpButton_SignUpPage().click();
    }
    @Then("Validate that Wrong message is {string}.")
    public void Wrong_message(String message) {
        SoftAssert softAssert=new SoftAssert();
        WebDriverWait wait = new WebDriverWait(signUp.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        String ExpectedResult=message;
        String ActualResult=signUp.driver.switchTo().alert().getText();
        softAssert.assertEquals(ExpectedResult,ActualResult);
        softAssert.assertAll();
        signUp.driver.switchTo().alert().accept();
    }



}
