package org.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumUtils {

   public static WebDriver driver;
  public static   WebDriverWait wait;
   public static FluentWait fluentwait;
   public static JavascriptExecutor js;
    public static Actions actions;

    public SeleniumUtils() {

    }
    public SeleniumUtils(WebDriver driver) {
        this.driver = driver;
       this.js= (JavascriptExecutor) driver;
       this.fluentwait= new FluentWait<>(driver);
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(60));
    }
    public WebElement Findelement(String xpath) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
       WebElement element= driver.findElement(By.xpath(xpath));
       return element;
    }

    public void Fluentwaits(WebElement element) {

        fluentwait.withTimeout(Duration.ofSeconds(60));
        fluentwait.pollingEvery(Duration.ofSeconds(5));
        fluentwait.ignoring(Throwable.class);
        fluentwait.until(ExpectedConditions.visibilityOf(element));
    }

    public void webdriverwaits(WebElement element) {
       wait = new WebDriverWait(driver, Duration.ofSeconds(60));
       wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(WebElement element) {
        element.click();
    }

    public void JsClick(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    public void Actionclick(WebElement element) {
        actions.moveToElement(element).click().build().perform();
    }

    public void Sendkeys(String xpath, String value) {
        Findelement(xpath).sendKeys(value);
    }

    public void WindowHandles() {
        String parentwindow = driver.getWindowHandle();
        driver.getWindowHandles().forEach(window -> {
            if (!window.equals(parentwindow)) {
                driver.switchTo().window(window);
            }
        });
    }

}
