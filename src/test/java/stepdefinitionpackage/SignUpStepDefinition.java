package stepdefinitionpackage;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import java.time.Duration;

public class SignUpStepDefinition {
    WebDriver driver;


    @Given("The user is on empty browser")
    public void the_user_is_on_empty_browser() {
        System.out.println("The browser is opening");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @When("The user has entered {string}")
    public void the_user_has_entered(String string) {
        System.out.println("The url is opening");

        driver.get(string);
    }

    @When("The user has entered the {string} and {string}")
    public void the_user_has_entered_the_and(String username, String password) {
        driver.findElement(By.xpath("//a[text()='Sign up']")).click();
        driver.findElement(By.xpath("//input[@id='sign-username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='sign-password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Sign up']")).click();
    }


    @Then("The SignIn should be successful")
    public void the_sign_in_should_be_successful() {

        System.out.println("The signin is successful");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }


    @Then("The SignIn should be unsuccessful")
    public void the_sign_in_should_be_unsuccessful()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        String actualAlertText = wait.until(ExpectedConditions.alertIsPresent()).getText();

        Assert.assertFalse(actualAlertText.contains("successful"),"The Sign Up is successful with Invalid Credintials");
        Reporter.log("The SignUp is Unsuccessful",true);
    }
}
