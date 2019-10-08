package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;

public class LoginStep {

    private final Logger log = Logger.getLogger(this.getClass());
    LoginPage login=new LoginPage();
    HomePage home=new HomePage();

    @Given("user navigates Web Orders homepage")
    public void user_navigates_Web_Orders_homepage() {
        Assert.assertEquals("Title doesn't match", "Web Orders Login", login.getTitle());
    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        log.info("logging into the app");
        login.performLogin();
    }

    @Then("user login should be successful")
    public void user_login_should_be_successful() {
        Assert.assertTrue("Login failed", home.verifyLoginIsSuccessful());

    }
}
