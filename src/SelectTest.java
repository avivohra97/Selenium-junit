import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class SelectTest {
    WebDriver driver;
    String url;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        url = "https://www.letskodeit.com/practice";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.manage().window().maximize();
    }

    @Test
    public void name() throws InterruptedException {
        driver.get(url);
        WebElement drop = driver.findElement(By.xpath("//select[@id='carselect']"));
        Select select = new Select(drop);
        for(WebElement opts: select.getOptions()){
            System.out.println(opts.getText());
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        select.selectByIndex(select.getOptions().size()-1);
        Select newSelect = new Select(driver.findElement(By.id("multiple-select-example")));
        newSelect.selectByIndex(0);
        newSelect.selectByIndex(1);
        newSelect.deselectAll();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
