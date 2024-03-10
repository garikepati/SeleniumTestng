package org.utils;
import org.Pages.LoginPage;
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
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;


public class BaseTest extends ReadPropertyfile {

    public static WebDriver driver=null;
   public static String browserName =propertyFile("browser");
   public static String url = propertyFile("url");
   protected ReadExcel Excel = new ReadExcel();
  public static SeleniumUtils seleniumUtils;
   public static LoginPage loginPage;
      PageFactory pageFactory;
    protected static
    ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

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

        }
        threadLocalDriver.set(driver);
        System.out.println("Before Test Thread ID: "+Thread.currentThread().getId());
        getDriver().get(url);
        seleniumUtils= new SeleniumUtils(getDriver());
        loginPage= new LoginPage(getDriver());
}

    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }

@AfterMethod(alwaysRun = true)
    public void tearDown()
    {
        getDriver().quit();
        System.out.println("After Test Thread ID: "+Thread.currentThread().getId());
        threadLocalDriver.remove();
    }
}


