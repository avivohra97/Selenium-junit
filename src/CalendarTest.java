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

public class CalendarTest {
    static WebDriver driver;
    static String baseURL;

    @BeforeClass
    public static void beforeClass() throws Exception {
        driver  = new FirefoxDriver();
        baseURL = "https://www.expedia.co.in/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void name() throws InterruptedException {
        driver.get(baseURL);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement buttons = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='uitk-date-selector-input1-default']")));
        buttons.click();

        List<WebElement> wb = driver.findElements(By.xpath("//table[@data-stid='month-table' and contains(@aria-label,'June')]//div[contains(@class,'uitk-day-clickable')]"));
        int date1 = (int)(Math.random()*wb.size())+1;
        wb.get(date1).click();
        wb.get(date1+1).click();
        Thread.sleep(2000);
    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.quit();

    }
}
