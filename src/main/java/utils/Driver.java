package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver() {

    }
    static WebDriver driver;

    public static WebDriver getDriver() {

        if(driver != null) {
            return driver;
        }
        //System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().setHeadless(false));
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(12, TimeUnit.SECONDS);
        return driver;
    }

    public static void closeDriver(){
        if(driver !=null) {
            driver.quit();
            driver = null;
        }
    }
}
