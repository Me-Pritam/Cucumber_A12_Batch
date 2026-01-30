package runnerpackage;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/featurepackage/RegistrationFeatureVinothQA.feature",
        glue = "stepdefinitionpackage",
        monochrome = true
)
public class RegistrationRunnerClass extends AbstractTestNGCucumberTests
{
}
