package runnerpackage;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/featurepackage/DemoBlazeCartFeature.feature",
        dryRun = false,
        monochrome = true,
        glue = "stepdefinitionpackage",
        plugin = {"html:target/Cucumber-html-Report.html",
                  "json:target/Cucumber-json-Report.html",
                  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }

)
public class CartWithTagsRunnerClass extends AbstractTestNGCucumberTests
{

}
