package runnerpackage;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/featurepackage",
        dryRun = false,
        monochrome = true,
        glue = "stepdefinitionpackage",
        plugin = {"html:target/cucumber-html-report.html",
                  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                 }
)
public class AddingItemtoCartRunnerClass extends AbstractTestNGCucumberTests
{
}
