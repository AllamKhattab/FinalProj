package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import stepDefs.Hooks;

import java.util.List;

public class TC02_Login {
    public WebDriver driver= Hooks.driver;
    public WebElement LoginButton_Homepage() {
        return driver.findElement(By.xpath("//a[@id='login2']"));
    }

    public WebElement userName() {
        return driver.findElement(By.xpath("//input[@id='loginusername']"));
    }

    public WebElement Password() {
        return driver.findElement(By.xpath("//input[@id='loginpassword']"));
    }

    public WebElement LoginButton_SignInPage() {
        return driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
    }
    public WebElement LogoutButton_Homepage() {
        By.xpath("//a[@id='logout2']");
        driver.findElement(By.xpath("//a[@id='logout2']"));
        return driver.findElement(By.xpath("//a[@id='logout2']"));
    }

    public By LogoutButton_HomepageBY() {
        By logout=By.xpath("//a[@id='logout2']");
        return logout;
    }


}

