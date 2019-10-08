package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Config;
import utils.Driver;

public class LoginPage {
    WebDriverWait wait;
    WebDriver driver;
    private final Logger log = Logger.getLogger(this.getClass());

    @FindBy(id="ctl00_MainContent_username")
    @CacheLookup
    private WebElement username;

    @FindBy(id="ctl00_MainContent_password")
    @CacheLookup
    private WebElement password;


    @FindBy(id="ctl00_MainContent_login_button")
    @CacheLookup
    private WebElement loginButton;

    @FindBy(xpath="//span[@class='error']")
    @CacheLookup
    private WebElement errorMessage;

    public LoginPage() {
        driver=Driver.getDriver();
        wait=new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public String getTitle(){
        String title=driver.getTitle();
        return title;
    }

    public void performLogin() {
       log.info("Entering username");
        username.sendKeys(Config.getValue("name"));
       log.info("Entering pass");
        password.sendKeys(Config.getValue("psw"));
       log.info("Clicking on login button");
        loginButton.click();
    }

    public void performLogin(String name, String psw) {
        username.sendKeys(name);
        password.sendKeys(psw);
        loginButton.click();
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText().trim();
    }

}
