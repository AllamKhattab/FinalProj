package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import stepDefs.Hooks;
import stepDefs.TC03_ProductSteps;

import java.util.List;

public class TC03_Product {
    public WebDriver driver= Hooks.driver;

public WebElement labtop(){
    return driver.findElement(By.xpath("//*[contains(text(), 'Laptops')]"));
}
    public By LabtopProduct() {
        By logout=By.xpath("//a[normalize-space()='MacBook Pro']");
        return logout;
    }

public List<WebElement> AddProduct() {
        return driver.findElements(By.xpath("//*[contains(@class,'mb-4')]"));
    }

public WebElement addToCartButton() {
        return driver.findElement(By.xpath("//a[normalize-space()='Add to cart']"));
    }

public WebElement CartButtonHomepage() {
        return driver.findElement(By.xpath("//a[@id='cartur']"));
    }

public WebElement Total() {
        return driver.findElement(By.xpath("//h3[@id='totalp']"));
    }

public WebElement Place_holder_button() {
        return driver.findElement(By.cssSelector(".btn.btn-success"));
    }

public WebElement total_amount_place_holder_page() {
        return driver.findElement(By.xpath("//label[@id='totalm']"));
    }

    public WebElement Name() {
        return driver.findElement(By.xpath("//input[@id='name']"));
    }
    public WebElement Country() {
        return driver.findElement(By.xpath("//input[@id='country']"));
    }
    public WebElement City() {
        return driver.findElement(By.xpath("//input[@id='city']"));
    }
    public WebElement CreditCard() {
        return driver.findElement(By.xpath("//input[@id='card']"));
    }
    public WebElement Month() {
        return driver.findElement(By.xpath("//input[@id='month']"));
    }
    public WebElement Year() {
        return driver.findElement(By.xpath("//input[@id='year']"));
    }
    public WebElement PurchaseButton() {
        return driver.findElement(By.xpath("//button[normalize-space()='Purchase']"));
    }
    public WebElement SuccessMessage() {
        return driver.findElement(By.xpath("//h2[normalize-space()='Thank you for your purchase!']"));
    }



}
