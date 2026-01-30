package stepdefinitionpackage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class LogInStepDefinition
{
    WebDriver driver;

    @Given("the user is on the Demoblaze login page")
    public void the_user_is_on_the_demoblaze_login_page()
    {
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.get("https://www.demoblaze.com/");

      driver.findElement(By.xpath("//a[text()='Log in']")).click();
    }
    @When("the user logs in with the following valid credentials")
    public void the_user_logs_in_with_the_following_valid_credentials(DataTable dataTable)
    {
        List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);

        for(Map<String,String> value:data)
        {
            driver.findElement(By.xpath("//input[@id='loginusername']"))
                    .sendKeys(value.get("username"));

            driver.findElement(By.xpath("//input[@id='loginpassword']"))
                    .sendKeys(value.get("password"));

            driver.findElement(By.xpath("//button[text()='Log in']"))
                    .click();
        }




    }
    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {

       WebElement welcomeLink = driver.findElement(By.xpath("//a[@id='nameofuser']"));

        Assert.assertTrue(welcomeLink.isDisplayed(),"The LogIm is unsuccessful");

        Reporter.log("The LogIn is succesful");
    }

}
