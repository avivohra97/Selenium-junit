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