package com.nathisonke.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends BasePage {

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private WebElement nameInput;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement signupButton;

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public void enterName(String name) {
        sendKeys(nameInput, name);
    }

    public void enterEmail(String email) {
        sendKeys(emailInput, email);
    }

    public void clickSignup() {
        clickElement(signupButton);
    }
}
