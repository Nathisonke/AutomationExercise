package stepDefinitions;

import com.nathisonke.pages.ProductsPage;
import com.nathisonke.utils.DriverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ProductSteps {

    WebDriver driver = DriverFactory.getDriver();
    ProductsPage productsPage = new ProductsPage(driver);

    @Given("user is on the home page")
    public void user_is_on_home_page() {
        driver.get("https://automationexercise.com/");
    }

    @When("user clicks on the {string} link")
    public void user_clicks_on_the_link(String linkName) {
        if (linkName.equalsIgnoreCase("Products")) {
            productsPage.clickProductsLink();
        }
    }

    @When("user enters {string} in the search box")
    public void user_enters_in_the_search_box(String keyword) {
        productsPage.enterSearchKeyword(keyword);
    }

    @When("user clicks the search button")
    public void user_clicks_the_search_button() {
        // Hide ads before clicking
        productsPage.hideAds();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        productsPage.clickSearchButton();
    }

    @Then("search results for {string} are displayed")
    public void search_results_are_displayed(String keyword) {
        Assert.assertTrue("Search results not displayed for " + keyword,
                productsPage.isSearchResultDisplayed(keyword));
    }

    @When("user adds the first product to the cart")
    public void user_adds_first_product_to_cart() {
        productsPage.addFirstProductToCart();
        
        // Add a small wait to ensure the cart action completes
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Then("the product should be successfully added to the cart")
    public void product_should_be_added_to_cart() {
        // Add more detailed verification with retries
        boolean isAdded = false;
        int attempts = 0;
        int maxAttempts = 3;
        
        while (!isAdded && attempts < maxAttempts) {
            try {
                Thread.sleep(1000); // Wait between attempts
                isAdded = productsPage.isProductAddedToCart();
                if (!isAdded) {
                    attempts++;
                    System.out.println("Attempt " + attempts + ": Cart confirmation not found, retrying...");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        
        Assert.assertTrue("Product not added to cart after " + maxAttempts + " attempts!", isAdded);
    }
}
