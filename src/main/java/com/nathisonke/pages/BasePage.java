package com.nathisonke.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    protected void clickElement(WebElement element) {
        wait.until(driver -> element.isDisplayed() && element.isEnabled());
        element.click();
    }

    protected void sendKeys(WebElement element, String text) {
        wait.until(driver -> element.isDisplayed() && element.isEnabled());
        element.clear();
        element.sendKeys(text);
    }
}
