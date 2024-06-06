import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AutoSuggestTest {
    static WebDriver driver;
    static String baseURL;

    @BeforeClass
    public static void beforeClass() throws Exception {
        driver  = new FirefoxDriver();
        baseURL = "https://www.goibibo.com/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void name() throws InterruptedException {
        driver.get(baseURL);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement buttons = driver.findElement(By.xpath("//span[@class='logSprite icClose']"));
        if(buttons.isDisplayed()){
            buttons.click();
        }
        Thread.sleep(3000);

        WebElement wb = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='From']")));
        wb = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='From']")));
        wb.click();
        wb = driver.findElement((By.xpath("//span[text()='From']//following-sibling::input")));
        wb.sendKeys("del");
        List<WebElement> opts = driver.findElements(By.xpath("//span[@class='autoCompleteSubTitle']"));
        for(WebElement ele: opts){
            if(ele.getText().contains("MDQ")){
                ele.click();
                break;
            }
        }
        Thread.sleep(3000);

    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.quit();

    }
}
