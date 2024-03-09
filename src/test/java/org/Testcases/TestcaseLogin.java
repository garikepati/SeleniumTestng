package org.Testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.utils.BaseTest;
import java.util.Set;

public class TestcaseLogin extends BaseTest
{

    @Test
    public void LoginTestCase() {
        System.out.println("Login to the application");

        driver.findElement(By.xpath("//div[@role='banner' and @class='h_container_sm' ]/div[2]/a")).click();
        driver.findElement(By.xpath("//button[contains(text(),'LOGIN')]")).click();
        String parentwindow = driver.getWindowHandle();
        Set<String> allwindows = driver.getWindowHandles();
        for (String window : allwindows) {
            if (!window.equals(parentwindow)){
                driver.switchTo().window(window);
            }
        }
        driver.findElement(By.xpath("//input[@aria-controls='pr_id_1_list']")).sendKeys(Excel.readExcel("Sheet1").get("2").get("username"));
    }

    @Test
    public void LaunchTestCase1() {
        System.out.println("Login to the application");
        driver.findElement(By.xpath("//div[@role='banner' and @class='h_container_sm' ]/div[2]/a")).click();
        driver.findElement(By.xpath("//button[contains(text(),'LOGIN')]")).click();
        String parentwindow = driver.getWindowHandle();
        Set<String> allwindows = driver.getWindowHandles();
        for (String window : allwindows) {
            if (!window.equals(parentwindow)){
                driver.switchTo().window(window);
            }
        }
        driver.findElement(By.xpath("//input[@aria-controls='pr_id_1_list']")).sendKeys(Excel.readExcel("Sheet1").get("2").get("username"));
    }


}

