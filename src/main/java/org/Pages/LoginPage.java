package org.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@role='banner' and @class='h_container_sm' ]/div[2]/a")
    private static String loginButton;

    @FindBy(xpath = "//button[contains(text(),'LOGIN')]")
    private static String loginButton1;

    @FindBy(xpath = "//input[@aria-controls='pr_id_1_list']")
    private static String username;

    public String getLoginButton() {
        return loginButton;
    }
    public String getLoginButton1() {
        return loginButton1;
    }

    public String getUsername() {
        return username;
    }
}
