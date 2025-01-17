package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pages.TC03_Product;

import java.time.Duration;
import java.util.List;

public class TC03_ProductSteps {

    TC03_Product product=new TC03_Product();
    public int p;
public double x;



    @Given("Click on Laptops in categories in home page.")
    public void pressOnLabtopButton()   {
        if (p>0){
            product.driver.navigate().to("https://www.demoblaze.com/index.html");
        }
     product.labtop().click();
        WebDriverWait wait = new WebDriverWait(product.driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.elementToBeClickable(product.LabtopProduct()));

    }

    @When("choose product {int}")
    public void AddProduct(int p){
    this.p=p;
    product.AddProduct().get(p).click();
    }

    @And("Click on Add to cart button.")
    public void pressOnProductButton(){
    product.addToCartButton().click();
    }

    @Then("Validate that product is successfully added.")
    public void Validate_that_product_is_successfully_added(){
        SoftAssert softAssert=new SoftAssert();
        WebDriverWait wait = new WebDriverWait(product.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        String ExpectedResult="Product added.";
        String ActualResult=product.driver.switchTo().alert().getText();
        softAssert.assertEquals(ExpectedResult,ActualResult);
        product.driver.switchTo().alert().accept();
    }

    @Given("Click on Cart button in header.")
    public void Click_on_Cart_button() throws InterruptedException {
        product.CartButtonHomepage().click();
        Thread.sleep(5000);
    }

    @Then("Validate that two products which include title and Price are successfully added in products page.")
    public void Validate_that_product_is_successfully_addedAll() {
        SoftAssert softAssert=new SoftAssert();
        double x=0;
        for (;p>=1;) {
            String Title = "//tbody/tr[" + (p ) + "]/td[2]";
            String Price = "//tbody/tr[" + (p ) + "]/td[3]";
            WebElement Titles = product.driver.findElement(By.xpath(Title));
            WebElement Prices = product.driver.findElement(By.xpath(Price));
            String ExpectedTitle=Titles.getText();
            String ExpectedPrice=Prices.getText();
            System.out.println(ExpectedTitle + "\n" + ExpectedPrice);
            softAssert.assertTrue(Titles.isDisplayed(), "Title is not displayed for product " + p);
            softAssert.assertTrue(Prices.isDisplayed(), "Price is not displayed for product " + p);
            softAssert.assertAll();

            x+=Double.parseDouble(ExpectedPrice);
            this.x=x;
            p--;
        }

    }



    @Then("Validate that total amount is calculated correctly.")
    public void Validate_that_total_amount_is_calculated_correctly() {

        double Actual= Double.parseDouble(product.Total().getText());
        SoftAssert softAssert=new SoftAssert();
softAssert.assertEquals(x,Actual);
softAssert.assertAll();
    }


    @Given("Click on Place holder button")
    public void Click_on_Place_holder_button() throws InterruptedException {

        product.Place_holder_button().click();
        Thread.sleep(5000);
    }


    @Then("Validate that total amount is calculated correctly in place holder page.")
    public void Validate_that_total_amount_is_calculated_correctly_in_place_holder_page() {

        double Actual= Double.parseDouble(product.total_amount_place_holder_page().getText().replaceAll("[^\\d.]", ""));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(x,Actual);
        softAssert.assertAll();
    }


    @When("Filling Name{string}, Country{string}, City{string}, Credit Cart{string}, Month{string} and Year{string}")
    public void FillingPlaceHolderForm(String name,String country,String city,String creditCart,String month,String year) {
product.Name().sendKeys(name);
        product.Country().sendKeys(country);
        product.City().sendKeys(city);
        product.CreditCard().sendKeys(creditCart);
        product.Month().sendKeys(month);
        product.Year().sendKeys(year);
    }


    @And("Click on Purchase button in place holder Form.")
    public void Click_on_Purchase_button_in_place_holder_Form() {

        product.PurchaseButton().click();
    }


    @Then("Validate that ‘Thank you for your purchase!’ should be displayed.")
    public void Validate_that_Thank_you_for_your_purchase_should_be_displayed() {
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals("Thank you for your purchase!",product.SuccessMessage().getText());
        softAssert.assertAll();
    }


}
