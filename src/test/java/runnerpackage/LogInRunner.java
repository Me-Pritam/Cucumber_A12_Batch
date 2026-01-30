package runnerpackage;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/featurepackage/LogIn.feature",
        glue = "stepdefinitionpackage",
        monochrome = true
)
public class LogInRunner extends AbstractTestNGCucumberTests
{

}
