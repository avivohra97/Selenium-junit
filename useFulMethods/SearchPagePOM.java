package useFulMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPagePOM {
    public WebElement element;

    public By staysHref = By.xpath("//li[@data-stid='uitk-tab-active']/a[@href='/Hotels']");
    public By destButton = By.xpath("//button[@data-stid='destination_form_field-dialog-trigger']");
    public By destInput = By.xpath("//input[@data-stid='destination_form_field-dialog-input']");
    public By options = By.xpath("//li[@data-stid='destination_form_field-result-item']");
    public By searchButton = By.xpath("//button[@id='search_button']");


    public WebElement getStaysHref(WebDriver driver) {
        return driver.findElement(staysHref);
    }

    public WebElement getDestButton(WebDriver driver) {
        return driver.findElement(destButton);
    }

    public WebElement getDestInput(WebDriver driver) {
        return driver.findElement(destInput);
    }

    public WebElement getOptions(WebDriver driver) {
        return driver.findElements(options).get(0);
    }

    public WebElement getSearchButton(WebDriver driver) {
        return driver.findElement(searchButton);
    }
}