package stepdefinitionpackage;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class SignUpWithDDTStepDefinition
{
    WebDriver driver;

    @Given("the user is on the Demoblaze Home page")
    public void the_user_is_on_the_demoblaze_home_page() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com/");

    }
    @When("The user clicks on SignUp")
    public void the_user_clicks_on_sign_up() {

        driver.findElement(By.xpath("//a[text()='Sign up']")).click();
    }
    @When("The user will SignUp using {string} and {string}")
    public void the_user_will_sign_up_using_and(String username, String password) {

        driver.findElement(By.xpath("//input[@id='sign-username']")).sendKeys(username);

        driver.findElement(By.xpath("//input[@id='sign-password']")).sendKeys(password);

        driver.findElement(By.xpath("//button[text()='Sign up']")).click();

    }
    @Then("The SignUp should be successful;")
    public void the_sign_up_should_be_successful() {

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));

        String alertText= wait.until(ExpectedConditions.alertIsPresent()).getText();

        SoftAssert sAssert = new SoftAssert();

        sAssert.assertTrue(alertText.contains("successful"),"The SignUp is Unsuccessful");

        Reporter.log("The Signup is successful",true);

        sAssert.assertAll();

    }
}
