package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.Config;
import utils.Driver;

public class Hooks {
    private final Logger log = Logger.getLogger(this.getClass());

    @Before
    public void setUp(){
        Driver.getDriver().get(Config.getValue("url"));
    }

    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()) {
            final byte [] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
            scenario.write("This scenario failed");
        }
        log.info("Closing the app");
        Driver.closeDriver();
    }
}
