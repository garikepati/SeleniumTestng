package org.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

public class LoginPage {

    public static WebDriver driver;

       public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public LoginPage() {
    }

    @FindBy(xpath = "//div[@role='banner' and @class='h_container_sm' ]/div[2]/a")
    private  WebElement loginButton;

    @FindBy(xpath = "//button[contains(text(),'LOGIN')]")
    private  WebElement loginButton1;

    @FindBy(xpath = "//input[@aria-controls='pr_id_1_list']")
    private WebElement  username;

    public WebElement getLoginButton() {
        System.out.println(loginButton.getTagName());
        return loginButton;
    }
    public WebElement getLoginButton1() {
        return loginButton1;
    }

    public WebElement getUsername() {
        return username;
    }
}
