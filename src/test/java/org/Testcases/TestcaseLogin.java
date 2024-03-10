package org.Testcases;

import org.Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.utils.BaseTest;
import org.utils.SeleniumUtils;

import java.util.Set;

public class TestcaseLogin extends BaseTest
{
    @Test
    public void LoginTestCase() {

        System.out.println("Page factory is initialized");
        loginPage.getLoginButton().click();
        loginPage.getLoginButton1().click();
        String parentwindow = driver.getWindowHandle();
        Set<String> allwindows = driver.getWindowHandles();
        for (String window : allwindows) {
            if (!window.equals(parentwindow)){
                driver.switchTo().window(window);
            }
        }
        loginPage.getUsername().sendKeys(Excel.readExcel("Sheet1").get("1").get("username"));
    }

    @Test
    public void LaunchTestCase1() {
        System.out.println("Login to the application");
        loginPage.getLoginButton().click();
        loginPage.getLoginButton1().click();
        String parentwindow = driver.getWindowHandle();
        Set<String> allwindows = driver.getWindowHandles();
        for (String window : allwindows) {
            if (!window.equals(parentwindow)){
                driver.switchTo().window(window);
            }
        }
        loginPage.getUsername().sendKeys(Excel.readExcel("Sheet1").get("1").get("username"));
    }


}

