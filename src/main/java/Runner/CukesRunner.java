package Runner;

import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"pretty","html:target/cucumber-html-report","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = {"src/features"},
        glue = "steps",
        tags="@table",
        monochrome = true,
        dryRun=false
)
public class CukesRunner {

}


