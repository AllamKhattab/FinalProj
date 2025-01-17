package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pages.TC02_Login;

import java.time.Duration;


public class TC02_LoginSteps {
TC02_Login login=new TC02_Login();
    @When("I click on the Login button in the header")
    public void ClickOnLoginButton(){
        login.LoginButton_Homepage().click();
    }

    @And ("I fill in the login form with username {string} and password {string}")
    public void enterValidLogin(String username,String password)  {
        login.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        login.userName().sendKeys(username);
        login.Password().sendKeys(password);
    }

    @Then("I should see that my account is opened successfully")
    public void myAccountIsOpenedSuccessfully(){
        login.LoginButton_SignInPage().click();
        SoftAssert softAssert=new SoftAssert();
        WebDriverWait wait = new WebDriverWait(login.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(login.LogoutButton_HomepageBY()));
        softAssert.assertTrue(login.LogoutButton_Homepage().isDisplayed(), "- Login was not successful.\n - Log out button is not visible.");
        softAssert.assertAll();
    }
}
