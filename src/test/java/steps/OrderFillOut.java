package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderPage;

public class OrderFillOut {

    LoginPage login=new LoginPage();
    HomePage home=new HomePage();
    OrderPage order=new OrderPage();
    private final Logger log = Logger.getLogger(this.getClass());

    @Given("user navigates to Orders page")
    public void user_navigates_to_Orders_page() {
        login.performLogin();
        order.waitForElementToBeClicakble(home.order);
        home.clickOnOrder();
    }

    @When("user selects product {string}")
    public void user_selects_product(String product) {
        order.selectProduct(product, order.dropdown);
        log.info("order selected");
    }

    @When("user enters the number of quantity {string}")
    public void user_enters_the_number_of_quantity(String quantity) {
     order.quantity.sendKeys(quantity);
    }

    @When("user clicks on calculate")
    public void user_clicks_on_calculate() {
        order.calculateBtn.click();
    }

    @When("user enters customer name {string}")
    public void user_enters_customer_name(String name) {
      order.nameBox.sendKeys(name);
    }

    @When("user enters street {string}")
    public void user_enters_street(String street) {
      order.streetBox.sendKeys(street);
    }

    @When("user enters city {string}")
    public void user_enters_city(String city) {
    order.cityBox.sendKeys(city);
    }

    @When("user enters state {string}")
    public void user_enters_state(String state) {
    order.stateBox.sendKeys(state);
    }

    @When("user enters zip code {string}")
    public void user_enters_zip_code(String zipCode) {
    order.zipBox.sendKeys(zipCode);
    }

    @When("user chooses card to pay {string}")
    public void user_chooses_card_to_pay(String card) {
        if(card.equalsIgnoreCase("visa")) {
            order.cardVisa.click();
        }
        else if(card.equalsIgnoreCase("master card")) {
            order.cardMaster.click();
        }
        else{
            order.cardAmEx.click();
        }
    }

    @When("user enters card number {string}")
    public void user_enters_card_number(String cardNumber) {
        order.cardNumBox.sendKeys(cardNumber);
    }

    @When("user enters expiry date {string}")
    public void user_enters_expiry_date(String expiryDate) {
        order.ExDateBox.sendKeys(expiryDate);
    }

    @When("user clicks Process button")
    public void user_clicks_Process_button() {
        log.info("clicking on the process button");
        order.processBtn.click();
    }

    @Then("user should see a message {string}")
    public void user_should_see_a_message(String successMessage) {

        order.waitForElementToBeVisible(order.OrderMessage);
        Assert.assertEquals(successMessage, order.OrderMessage.getText(), "Order message do not match");
    }
}
