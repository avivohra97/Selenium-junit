import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import useFulMethods.GenericMethods;

public class FirstTestWithGenericMethods {
    private static FirefoxDriver driver;
    WebElement element;
    GenericMethods gm;
    String baseURL;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver(); //Initialising the browser driver
        gm = new GenericMethods(driver);
        baseURL = "https://letskodeit.teachable.com/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }

    @Test
    public void name() {
        driver.get(baseURL);
        gm.getElement("//a[@href='/sign_in']","xpath").click();
        driver.navigate().back();
    }

    @After
    public void tearDown(){
        driver.quit(); //Closing the driver once the tests are executed
    }
}