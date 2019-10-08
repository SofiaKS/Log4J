package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.util.List;

public class HomePage {

    private final Logger log = Logger.getLogger(this.getClass());
    WebDriverWait wait;
    WebDriver driver;

    @FindBy(xpath="//div[@class='login_info']")
    @CacheLookup
    private WebElement welcomeMessage;

    @FindBy(linkText="View all products")
    @CacheLookup
    private WebElement products;

    @FindBy(linkText="Order")
    @CacheLookup
    public WebElement order;

    @FindBy(xpath="//ul[@id='ctl00_menu']//li//a")
    @CacheLookup
    private List<WebElement> menuItems;


    @FindBy(xpath="//div[@class='content']//h2")
    @CacheLookup
    private WebElement productText;


    @FindBy(xpath="//table[@class='ProductsTable']")
    @CacheLookup
    private WebElement productTable;





    public HomePage() {
        driver=Driver.getDriver();
        wait=new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public boolean verifyLoginIsSuccessful() {
        wait.until(ExpectedConditions.visibilityOf(welcomeMessage));
        log.info("Welcome message is displayed");
        return true;
    }

    public boolean verifyProductsTabelDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(productTable));
        if(!productTable.isDisplayed()) {
            return false;
        }
        return true;
    }

    public int getMenuItemsNumber() {
        return menuItems.size();
    }

    public String getProductListHeader() {
        return productText.getText().trim();
    }

    public void clickOnAllProducts() {
        products.click();
    }

    public void clickOnOrder() {
        log.info("Clicking on order link");
        order.click();
    }
}
