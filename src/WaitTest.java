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

public class WaitTest {
    static WebDriver driver;
    static String baseURL;

    @BeforeClass
    public static void beforeClass() throws Exception {
        driver  = new FirefoxDriver();
        baseURL = "https://www.letskodeit.com/practice";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void name() throws InterruptedException {
        driver.get(baseURL);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement buttons = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='navbar-inverse-collapse']/div/div/a")));
        buttons.click();

        WebElement wb = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        wb.sendKeys("avi");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.quit();

    }
}
