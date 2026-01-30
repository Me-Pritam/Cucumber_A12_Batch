package runnerpackage;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/featurepackage/DemoBlazeCartFeature.feature",
        dryRun = false,
        monochrome = true,
        glue = "stepdefinitionpackage"

)
public class CartWithTagsRunnerClass extends AbstractTestNGCucumberTests
{

}
