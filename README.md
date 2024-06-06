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