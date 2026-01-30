package stepdefinitionpackage;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class RegistrationStepDefiniton
{
    WebDriver driver;

    @Given("the user is on the Registration Page")
    public void the_user_is_on_the_registration_page()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://vinothqaacademy.com/demo-site/");

        Assert.assertEquals(driver.getCurrentUrl(),"https://vinothqaacademy.com/demo-site/","The Registration page is not opened");
        Reporter.log("The Registration page is opened",true);
    }
    @When("the user enters all valid data")
    public void the_user_enters_all_valid_data(io.cucumber.datatable.DataTable dataTable)
    {
        Map<String,String> dataSet = dataTable.asMap(String.class,String.class);

        driver.findElement(By.xpath("//input[@id='vfb-5']")).sendKeys(dataSet.get("firstName"));
        driver.findElement(By.xpath("//input[@id='vfb-7']")).sendKeys(dataSet.get("lastName"));
        List<WebElement> allGenders =  driver.findElements(By.xpath("//li[@id='item-vfb-31']/descendant::span[@class='vfb-span']/label"));

        for(WebElement element : allGenders)
        {
            if (element.getText().equals(dataSet.get("gender")))
            {
                element.click();
                break;
            }
        }

        List<WebElement> allSubjects = driver.findElements(By.xpath("//li[@id='item-vfb-20']/descendant::span[@class='vfb-span']/label"));

        for(WebElement subject : allSubjects)
        {
            if (subject.getText().equals(dataSet.get("course")))
            {
                subject.click();
                break;
            }
        }

        driver.findElement(By.xpath("//input[@id='vfb-13-address']")).sendKeys(dataSet.get("street"));

        driver.findElement(By.xpath("//input[@id='vfb-13-address-2']")).sendKeys(dataSet.get("aptNum"));

        driver.findElement(By.xpath("//input[@id='vfb-13-state']")).sendKeys(dataSet.get("state"));

        driver.findElement(By.xpath("//input[@id='vfb-13-zip']")).sendKeys(dataSet.get("city"));

        Select selectCountry = new Select(driver.findElement(By.xpath("//select[@name='vfb-13[country]']")));

        selectCountry.selectByVisibleText(dataSet.get("country"));


    }
    @Then("the Registration should be successful")
    public void the_registration_should_be_successful() {

    }
}
