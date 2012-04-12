package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class NewLoginNameAndLoginTester {

    public static void main(String[] args) {
        
        WebDriver driver = new HtmlUnitDriver();

        // etusivu
        driver.get("http://localhost:8080");
        System.out.println(driver.getPageSource());
        
        // uusi tunnus
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        System.out.println("==");

        // uuden tunnuksen submittointi
        System.out.println(driver.getPageSource());
        element = driver.findElement(By.name("username"));
        element.sendKeys("newuser");
        element = driver.findElement(By.name("password"));
        element.sendKeys("newp4ssword");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("newp4ssword");
        element = driver.findElement(By.name("add"));
        element.submit();

        System.out.println("==");
        System.out.println(driver.getPageSource());
       
         // takaisin etusivulle
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        System.out.println("==");
        System.out.println(driver.getPageSource());
       
        // logataan ulos
        element = driver.findElement(By.linkText("logout"));
        element.click();
        System.out.println("==");
        System.out.println(driver.getPageSource());
       
        // mennään login-sivulle
        element = driver.findElement(By.linkText("login"));
        element.click();
        System.out.println("==");

        // ja logataan taas sisään
        System.out.println(driver.getPageSource());
        element = driver.findElement(By.name("username"));
        element.sendKeys("newuser");
        element = driver.findElement(By.name("password"));
        element.sendKeys("newp4ssword");
        element = driver.findElement(By.name("login"));
        element.submit();
        

    }
}
