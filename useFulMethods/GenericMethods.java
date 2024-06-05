package useFulMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GenericMethods{
    public WebDriver driver;

    public GenericMethods(WebDriver driver){
        this.driver = driver;
    }
    public WebElement getElement(String locator, String type){
        type = type.toLowerCase();
        if(type.equals("xpath")){
            return this.driver.findElement(By.xpath(locator));
        } else if(type.equals("id")){
            return this.driver.findElement(By.id(locator));
        }if(type.equals("cssselector")){
            return this.driver.findElement(By.cssSelector(locator));
        }else{
            System.out.println("No locator matched");
            return null;
        }
    }

    public List<WebElement> getElementList(String locator, String type){
        type = type.toLowerCase();
        if(type.equals("xpath")){
            return this.driver.findElements(By.xpath(locator));
        } else if(type.equals("id")){
            return this.driver.findElements(By.id(locator));
        }if(type.equals("cssselector")){
            return this.driver.findElements(By.cssSelector(locator));
        }else{
            System.out.println("No locator matched");
            return null;
        }
    }
}