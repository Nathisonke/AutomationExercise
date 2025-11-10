package stepDefinitions;

import com.nathisonke.pages.HomePage;
import com.nathisonke.pages.LoginPage;
import hooks.ApplicationHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;

    @Given("I am on the automation exercise website")
    public void i_am_on_the_automation_exercise_website() {
        driver = ApplicationHooks.getDriver();
        driver.get("https://automationexercise.com/");
        homePage = new HomePage(driver);
    }

    @When("I navigate to the login page")
    public void i_navigate_to_the_login_page() {
        homePage.clickSignupLogin();
        loginPage = new LoginPage(driver);
    }

    @When("I enter email {string} and password {string}")
    public void i_enter_email_and_password(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLogin();
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        Assert.assertTrue("Error message should be displayed", loginPage.isErrorMessageDisplayed());
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        homePage = new HomePage(driver);
        Assert.assertTrue("Home page should be displayed", homePage.isHomePageDisplayed());
    }

    // NEW step definitions to match your feature file
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver = ApplicationHooks.getDriver();
        driver.get("https://automationexercise.com/");
        homePage = new HomePage(driver);
        homePage.clickSignupLogin();
        loginPage = new LoginPage(driver);
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {

        loginPage.enterEmail("pelesonke@gmail.com");
        loginPage.enterPassword("123456");
    }

    @When("the user enters invalid credentials")
    public void the_user_enters_invalid_credentials() {
        loginPage.enterEmail("pelesonke@gmail.com");
        loginPage.enterPassword("password");
    }

    @When("clicks the login button")
    public void clicks_the_login_button() {
        loginPage.clickLogin();
    }

    @Then("the user should be redirected to the homepage")
    public void the_user_should_be_redirected_to_the_homepage() {
        homePage = new HomePage(driver);
        Assert.assertTrue("User should be redirected to homepage", homePage.isHomePageDisplayed());
    }

    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {
        Assert.assertTrue("Error message should be displayed", loginPage.isErrorMessageDisplayed());
    }
}
