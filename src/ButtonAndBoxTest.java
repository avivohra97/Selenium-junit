import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class ButtonAndBoxTest {
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
        List<WebElement> buttons = driver.findElements(By.xpath("//div[@id='radio-btn-example']//input[@type='radio']"));
        for(WebElement elem: buttons){
            try {
                elem.click();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        List<WebElement> boxes = driver.findElements(By.xpath("//div[@id='checkbox-example-div']//input[@type='checkbox']"));
        for(WebElement ele: boxes) {
            try {
                ele.click();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(boxes.get(0).isSelected()+ "-> box is selected");



    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.quit();

    }
}
