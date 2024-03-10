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
        seleniumUtils.JsClick(loginPage.getLoginButton());
        seleniumUtils.JsClick(loginPage.getLoginButton1());
        seleniumUtils.WindowHandles();
        loginPage.getUsername().sendKeys(Excel.readExcel("Sheet1").get("1").get("username"));
    }

    @Test
    public void LaunchTestCase1() {
        seleniumUtils.JsClick(loginPage.getLoginButton());
        seleniumUtils.JsClick(loginPage.getLoginButton1());
        seleniumUtils.WindowHandles();
        loginPage.getUsername().sendKeys(Excel.readExcel("Sheet1").get("2").get("username"));
    }


}

