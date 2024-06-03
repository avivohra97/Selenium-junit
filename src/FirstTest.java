import java.util.concurrent.TimeUnit;

import org.junit.AfterClass; //Importing all the JUnit and Selenium classes
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTest {
    private static FirefoxDriver driver;
    WebElement element;

    @BeforeClass
    public static void openBrowser(){
        driver = new FirefoxDriver(); //Initialising the browser driver
    }

    @Test
    public void validUserCredentials(){ //To test successful login

        System.out.println("This is the test code " + new Object(){}.getClass().getEnclosingMethod().getName());
        driver.get("https://www.browserstack.com");
        driver.findElement(By.xpath(".//*[@id='account']/a")).click();
        driver.findElement(By.id("log")).sendKeys("userid"); //Sending ID
        driver.findElement(By.id("pwd")).sendKeys("userpassword"); // Sending PWD
        driver.findElement(By.id("login")).click();
        try{
            element = driver.findElement (By.xpath(".//*[@id='account_logout']/a"));
        }catch (Exception e){
        }
        Assert.assertNotNull(element); //Checking the element presence
        System.out.println("Test End " + new Object(){}.getClass().getEnclosingMethod().getName());
    }

    @Test
    public void WrongUserCredentials()
    {
        System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
        driver.get("https://www.browserstack.com");
        driver.findElement(By.xpath(".//*[@id='account']/a")).click();
        driver.findElement(By.id("log")).sendKeys("userid");
        driver.findElement(By.id("pwd")).sendKeys("userpassword"); //Entering wrong pwd
        driver.findElement(By.id("login")).click();
        try{
            element = driver.findElement (By.xpath(".//*[@id='account_logout']/a"));
        }catch (Exception e){
        }
        Assert.assertNotNull(element);
        System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
    }

    @AfterClass
    public static void closeBrowser(){
        driver.quit(); //Closing the driver once the tests are executed
    }
}