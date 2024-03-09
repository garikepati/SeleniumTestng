package org.utils;


import org.openqa.selenium.Beta;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.manager.SeleniumManagerOutput;
import org.openqa.selenium.remote.service.DriverFinder;
import org.testng.annotations.*;

public class BaseTest extends ReadPropertyfile {

    public static WebDriver driver=null;
   public String browserName =propertyFile("browser");
   public String url = propertyFile("url");
protected ReadExcel Excel = new ReadExcel();

    @BeforeMethod(alwaysRun = true)
    public void InitializeBrowser() {
    if(browserName.equalsIgnoreCase("chrome")){
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--start-maximized");
        ChromeDriverService service = new ChromeDriverService.Builder().build();
        options.setBrowserVersion("stable");
        SeleniumManagerOutput.Result location =
                DriverFinder.getPath(ChromeDriverService.createDefaultService(), options);
        driver = new ChromeDriver(service, options);
        driver.get(url);
    } else if (browserName.equalsIgnoreCase("firefox")) {
        FirefoxOptions options= new FirefoxOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--start-maximized");
        options.setBrowserVersion("stable");

    } else if (browserName.equalsIgnoreCase("Edge")) {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--start-maximized");
        options.setBrowserVersion("stable");
        EdgeDriverService service= new EdgeDriverService.Builder().build();
        SeleniumManagerOutput.Result location =
                DriverFinder.getPath(EdgeDriverService.createDefaultService(), options);
        driver= new EdgeDriver(service, options);
        driver.get(url);

    }
}

public WebDriver getDriver() {
    return driver;
}

@AfterMethod(alwaysRun = true)
    public void tearDown()
    {
        driver.quit();
    }
}


