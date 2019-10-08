package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

public class OrderPage {

    private final Logger log = Logger.getLogger(this.getClass());
    WebDriverWait wait;
    WebDriver driver;

    public OrderPage() {
        driver=Driver.getDriver();
        wait=new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement dropdown;

    @FindBy(id="ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantity;

    @FindBy(css="input[type='submit']")
    public WebElement calculateBtn;

    @FindBy(id="ctl00_MainContent_fmwOrder_txtName")
    public WebElement nameBox;

    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement streetBox;

    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement cityBox;

    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement stateBox;

    @FindBy (id="ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zipBox;

    @FindBy(id="ctl00_MainContent_fmwOrder_cardList_0")
    public WebElement cardVisa;

    @FindBy(id="ctl00_MainContent_fmwOrder_cardList_1")
    public WebElement cardMaster;

    @FindBy(id="ctl00_MainContent_fmwOrder_cardList_2")
    public WebElement cardAmEx;

    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNumBox;

    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement ExDateBox;

    @FindBy(id="ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processBtn;

    @FindBy(tagName="strong")
    public WebElement OrderMessage;


    public void selectProduct(String str, WebElement element) {
        log.info("Selecting a product");
        Select s=new Select(element);
        s.selectByVisibleText(str);
    }

    public void waitForElementToBeVisible(WebElement element){
        log.info("Waiting for element to be visible");
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClicakble(WebElement element){
        log.info("Waiting for element to be clickable");
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
