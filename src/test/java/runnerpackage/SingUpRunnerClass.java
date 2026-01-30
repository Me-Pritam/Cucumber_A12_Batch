package runnerpackage;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "./src/test/java/featurepackage/SignUp.feature",
        glue = "stepdefinitionpackage",
        monochrome = true,
        plugin = {"pretty",
                "html:target/cucumber-html-report.html",
                "json:target/cucumber-json-report.json"
        }
)
public class SingUpRunnerClass extends AbstractTestNGCucumberTests{
}
