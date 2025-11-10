package com.nathisonke.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Signup / Login')]")
    private WebElement signupLoginLink;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement homeLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickSignupLogin() {
        clickElement(signupLoginLink);
    }

    public boolean isHomePageDisplayed() {
        return homeLink.isDisplayed();
    }
}
