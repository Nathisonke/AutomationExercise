package stepDefinitions;

import com.nathisonke.pages.CheckoutPage;
import com.nathisonke.pages.ProductsPage;
import com.nathisonke.utils.DriverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CheckoutSteps {

    WebDriver driver = DriverFactory.getDriver();
    ProductsPage productsPage = new ProductsPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);

    @When("user clicks on the Cart link")
    public void user_clicks_cart_link() {
        checkoutPage.clickCartLink();
    }

    @When("user proceeds to checkout")
    public void user_proceeds_to_checkout() {
        checkoutPage.clickProceedToCheckout();
    }

    @When("user logs in with valid credentials {string} and {string}")
    public void user_logs_in(String email, String password) {
        checkoutPage.loginDuringCheckout(email, password);
    }

    @Then("the checkout page is displayed")
    public void the_checkout_page_is_displayed() {
        Assert.assertTrue("Checkout page is not displayed!", checkoutPage.isCheckoutPageDisplayed());
    }
}
