# Selenium-junit

```
select.selectByIndex(select.getOptions().size()-1);
Select newSelect = new Select(driver.findElement(By.id("multiple-select-example")));
newSelect.selectByIndex(0);
newSelect.selectByIndex(1);
newSelect.deselectAll();
```

```elem.getText()```

```
driver  = new FirefoxDriver();
baseURL = "https://letskodeit.teachable.com/";
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.manage().window().maximize();
```

```
List<WebElement> wb = driver.findElements(By.xpath("//table[@data-stid='month-table' and contains(@aria-label,'June')]//div[contains(@class,'uitk-day-clickable')]"));
int date1 = (int)(Math.random()*wb.size())+1;
wb.get(date1).click();
wb.get(date1+1).click();
```

Alternate to auto suggest:
```
String inHtml = <webelement>.getAttribute("innerHtml");
list <webelements> wb = webelement.findelements(xpath)

```

Screenshots

```
public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
//Convert web driver object to TakeScreenshot
TakesScreenshot scrShot =((TakesScreenshot)webdriver);
//Call getScreenshotAs method to create image file
File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//Move image file to new destination
File DestFile=new File(fileWithPath);
//Copy file at destination
FileUtils.copyFile(SrcFile, DestFile);
} 
```

Javascript executor
``` 
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
```

scroll and more 
``` 
executeAsyncScript("window.scrollBy(0,document.body.scrollHeight)");
window.location = <url>

window.innerHeight
window.width
window.scrollBy(<horizontalPixel>,<verticalPixel>)

webelement wb 

"argument[0].scrollIntoView(true);", element
"argument[0].click();", element
```

``` 
WebDriver driver = new ChromeDriver();
driver.get("URL”); URL OF WEBPAGE HAVING FRAMES
//First finding the element using any of locator stratedgy
WebElement iframeElement = driver.findElement(By.id("iframeResult"));
//now using the switch command
driver.switchTo().frame(iframeElement);
driver.quit();
```

``` 
1. Void dismiss(): This method is used when the ‘Cancel’ button is clicked in the alert box.

driver.switchTo().alert().dismiss();
2. Void accept(): This method is used to click on the ‘OK’ button of the alert.

driver.switchTo().alert().accept();
3. String getText(): This method is used to capture the alert message.

driver.switchTo().alert().getText();
4. Void sendKeys(String stringToSend): This method is used to send data to the alert box.

driver.switchTo().alert().sendKeys("Text");

 To cross-verify or handle alerts manually, one can paste the below command.

driver.findElement(By.xpath("//a[@class='bs-alert-close']")).click();
```

``` 
get.windowhandle(): This method helps to get the window handle of the current window
get.windowhandles(): This method helps to get the handles of all the windows opened
set: This method helps to set the window handles in the form of a string. set<string> set= driver.get.windowhandles()
switch to: This method helps to switch between the windows
action: This method helps to perform certain actions on the windows

driver.get("http://www.naukri.com/");

// It will return the parent window name as a String
String parent=driver.getWindowHandle();

Set<String>s=driver.getWindowHandles();

// Now iterate using Iterator
Iterator<String> I1= s.iterator();

while(I1.hasNext())
{

String child_window=I1.next();


if(!parent.equals(child_window))
{
driver.switchTo().window(child_window);
System.out.println(driver.switchTo().window(child_window).getTitle());

driver.close();
}

}
//switch to the parent window
driver.switchTo().window(parent);
```

``` 
 WebElement currentAddress=driver.findElement(By.id("currentAddress"));
currentAddress.sendKeys("43 School Lane London EC71 9GO");

// Copy the Current Address
currentAddress.sendKeys(Keys.CONTROL);
currentAddress.sendKeys("A");
currentAddress.sendKeys(Keys.CONTROL);
currentAddress.sendKeys("C");

//Press the TAB Key to Switch Focus to Permanent Address
currentAddress.sendKeys(Keys.TAB);

click action 

Actions action = new Actions(driver);
action.moveToElement(element).click();

hover

ac.moveToElement(live).build().perform();

double click

a.doubleClick(trialaction).perform();

drag and drop

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        new Actions(driver)
                .dragAndDrop(draggable, droppable)
                .perform();
                
                
```

``` 
No such element exception

why:
1. Timing issues
    soln: Use implicit wait
    
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    
    
          use explecit waits

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement buttons = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='navbar-inverse-collapse']/div/div/a")));
        buttons.click();
2. Incorrect locator
3. Element in Iframe


```

``` 
element not clickable

why:
1. some other element is overlapping
soln:

wait for invisibility of overlapping element.

boolean invisible = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='navbar-inverse-collapse']/div/div/a")));
if (invisible){
    <now click web element>
}

or

use javascript executor

webelement ele;

js.executeScript("argument[0].click();",ele);

this will do a hard click instead of being stuck with overlap
```

``` 
stale element exception
not fresh
some action has caused to reload or refresh the dom

ele
driver.get(<url>)
ele.click;

soln:

find element only when needed.

why:
element is not there now.

soln: break statement to avoid re reference
```

``` 

element not interactable

element is present but not in view port.

or hidden state or it cannot accept the action performed

like: sendKeys to form or h4 tag
```

