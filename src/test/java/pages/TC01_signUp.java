package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import stepDefs.Hooks;

public class TC01_signUp {
    public WebDriver driver=Hooks.driver;
    // Locators and actions for login functionality

    public WebElement SignUpButton_Homepage() {
        return driver.findElement(By.xpath("//a[@id='signin2']"));
    }

    public WebElement userName() {
        return driver.findElement(By.xpath("//input[@id='sign-username']"));
    }

    public WebElement Password() {
        return driver.findElement(By.xpath("//input[@id='sign-password']"));
    }

    public WebElement SignUpButton_SignUpPage() {
        return driver.findElement(By.xpath("//button[normalize-space()='Sign up']"));
    }


}
