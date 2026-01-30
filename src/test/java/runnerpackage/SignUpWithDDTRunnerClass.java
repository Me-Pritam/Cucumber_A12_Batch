package runnerpackage;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/java/featurepackage/SignUpWithDifferentCredintials.feature",
        monochrome = true,
        glue = "stepdefinitionpackage"
)
public class SignUpWithDDTRunnerClass extends AbstractTestNGCucumberTests
{
    @DataProvider
    @Override
    public Object[][] scenarios()
    {
        return super.scenarios();
    }
}
