package com.nathisonke.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

public class ProductsPage extends BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By productsLink = By.xpath("//a[@href='/products']");
    private By searchBox = By.id("search_product");
    private By searchButton = By.id("submit_search");
    private By searchResults = By.cssSelector(".productinfo.text-center");
    private By addToCartButtons = By.cssSelector(".add-to-cart");

    public ProductsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickProductsLink() {
        driver.findElement(productsLink).click();
    }

    public void enterSearchKeyword(String keyword) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(keyword);
    }

    public void clickSearchButton() {
        WebElement searchButtonElement = wait.until(ExpectedConditions.presenceOfElementLocated(searchButton));
        
        // Strategy 1: Try JavaScript click (most reliable for ad interference)
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchButtonElement);
            return;
        } catch (Exception e) {
            System.out.println("JavaScript click failed, trying regular click...");
        }
        
        // Strategy 2: Try regular click
        try {
            wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
            return;
        } catch (Exception e) {
            throw new RuntimeException("All click strategies failed for search button", e);
        }
    }

    public boolean isSearchResultDisplayed(String keyword) {
        List<WebElement> results = driver.findElements(searchResults);
        return results.size() > 0;
    }

    public void addFirstProductToCart() {
        List<WebElement> buttons = driver.findElements(addToCartButtons);
        if (!buttons.isEmpty()) {
            // Use JavaScript click to avoid ad interception
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttons.get(0));
        }
    }

    public boolean isProductAddedToCart() {
        WebElement modal = driver.findElement(By.id("cartModal"));
        return modal.isDisplayed();
    }
    
    // Helper method to hide ads
    public void hideAds() {
        try {
            ((JavascriptExecutor) driver).executeScript(
                "var ads = document.querySelectorAll('iframe[src*=\"googleads\"], iframe[src*=\"doubleclick\"], .advertisement, .ad-banner');" +
                "for(var i = 0; i < ads.length; i++) { ads[i].style.display = 'none'; }"
            );
        } catch (Exception e) {
            // Ignore if ad hiding fails
        }
    }
}
