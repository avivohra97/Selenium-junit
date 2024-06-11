import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.*;
public class JavascriptExecuteTest {
    @Test

    public void login() {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.manage().window().maximize();
        driver.get("https://www.browserstack.com/users/sign_in");
//        to eneter value
        js.executeScript("document.getElementById('user_email_login').value='rbc@xyz.com';");
        js.executeScript("document.getElementById('user_password').value='password';");
//         for actions
        js.executeScript("document.getElementById('user_submit').click();");
        js.executeScript("alert('enter correct login credentials to continue');");
        sleep(2000);
    }

    public static void sleep(int ms)
    {
        try

        {
            Thread.sleep(ms);
        }
        catch(InterruptedException e)

        {
            e.printStackTrace();
        }

    }
}