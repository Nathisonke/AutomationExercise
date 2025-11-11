package com.nathisonke.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private WebDriver driver;

    private By cartLink = By.xpath("//a[@href='/view_cart']");
    private By proceedToCheckoutButton = By.xpath("//a[text()='Proceed To Checkout']");
    private By loginEmailField = By.xpath("//input[@data-qa='login-email']");
    private By loginPasswordField = By.xpath("//input[@data-qa='login-password']");
    private By loginButton = By.xpath("//button[@data-qa='login-button']");
    private By checkoutHeader = By.xpath("//h2[contains(text(),'Address Details')]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickCartLink() {
        driver.findElement(cartLink).click();
    }

    public void clickProceedToCheckout() {
        driver.findElement(proceedToCheckoutButton).click();
    }

    public void loginDuringCheckout(String email, String password) {
        driver.findElement(loginEmailField).sendKeys(email);
        driver.findElement(loginPasswordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean isCheckoutPageDisplayed() {
        return driver.findElement(checkoutHeader).isDisplayed();
    }
}
