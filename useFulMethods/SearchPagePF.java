package useFulMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPagePF {
    public WebDriver driver;

    @FindBy(xpath = "//li[@data-stid='uitk-tab-active']/a[@href='/Hotels']")
    public WebElement staysHref;
    @FindBy(xpath = "//button[@data-stid='destination_form_field-dialog-trigger']")
    WebElement destButton;
    @FindBy(xpath = "//input[@data-stid='destination_form_field-dialog-input']")
    WebElement destInput;
    @FindBy(xpath = "//li[@data-stid='destination_form_field-result-item']")
    WebElement options;
    @FindBy(xpath = "//button[@id='search_button']")
    WebElement searchButton;

    public SearchPagePF(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }
}