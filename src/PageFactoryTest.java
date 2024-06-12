import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import useFulMethods.SearchPagePF;
import useFulMethods.SearchPagePOM;
import useFulMethods.SearchPagePOM.*;
import java.time.Duration;
import java.util.List;

public class PageFactoryTest {
    public  WebDriver driver;
    public  String baseURL;
    public SearchPagePF page;


    @Before
    public void setUp() throws Exception {
        driver  = new FirefoxDriver();
        baseURL = "https://www.expedia.com/";
        page = new SearchPagePF(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @Test
    public void name() throws InterruptedException {
        driver.get(baseURL);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        WebElement stays = wait.until(ExpectedConditions.elementToBeClickable(page.staysHref));
        stays.click();


    }


    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
