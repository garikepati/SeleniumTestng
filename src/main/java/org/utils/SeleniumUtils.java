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

    WebDriver driver;
    WebDriverWait wait;
    FluentWait fluentwait;
    JavascriptExecutor js;
    Actions actions;

    public SeleniumUtils(WebDriver driver) {
        this.driver = driver;
        js= (JavascriptExecutor) driver;
        fluentwait= new FluentWait<>(driver);
        wait= new WebDriverWait(driver, Duration.ofSeconds(60));
    }
    public WebElement Findelement(String xpath) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
       WebElement element= driver.findElement(By.xpath(xpath));
       return element;
    }

    public void Fluentwaits(String xpath) {

        fluentwait.withTimeout(Duration.ofSeconds(60));
        fluentwait.pollingEvery(Duration.ofSeconds(5));
        fluentwait.ignoring(Throwable.class);
        fluentwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
    }

    public void webdriverwaits(String xpath) {
       wait = new WebDriverWait(driver, Duration.ofSeconds(60));
       wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
    }

    public void click(String xpath) {
        Findelement(xpath).click();
    }

    public void JsClick(String xpath) {
        WebElement element = Findelement(xpath);
        js.executeScript("arguments[0].click();", element);
    }

    public void Actionclick(String xpath) {
        WebElement element = Findelement(xpath);
        actions.moveToElement(element).click().build().perform();
    }

    public void Sendkeys(String xpath, String value) {
        Findelement(xpath).sendKeys(value);
    }


}
