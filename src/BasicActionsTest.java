import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BasicActionsTest {
    static WebDriver driver;
    static String baseURL;

    @BeforeClass
    public static void beforeClass() throws Exception {
        driver  = new FirefoxDriver();
        baseURL = "https://letskodeit.teachable.com/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void name() {
        driver.get(baseURL);
        driver.findElement(By.xpath("//a[@href='/sign_in']")).click();
        driver.navigate().back();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(driver.getTitle().equals("Home | Let's Kode It"))
            driver.navigate().forward();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//input[@id='email']")).clear();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test@email.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("test");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.quit();

    }
}
