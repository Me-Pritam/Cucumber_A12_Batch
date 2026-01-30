package stepdefinitionpackage;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import pomPackage.POMFactory;
import utilsPackage.TestContext;
import utilsPackage.UtilityFactory;
import utilsPackage.WebDriverUtility;

import java.time.Duration;
import java.util.List;

public class CartFeaturesUsingTagsStepDefinitions
{
    WebDriverUtility web;
    UtilityFactory utility;
    POMFactory pom;
    TestContext context;


    public CartFeaturesUsingTagsStepDefinitions(WebDriverUtility web, UtilityFactory utility, TestContext context)
    {

        this.web = web;
        this.utility = utility;
        this.context=context;
    }

    private POMFactory pom()
    {
        if (pom==null)
        {
            pom = context.getPomFactory();
        }
        return pom;
    }


    @Given("The User is present on the DemoBlaze HomePage")
    public void the_user_is_present_on_the_demo_blaze_home_page()
    {

        utility.assertion.isSameUrl(web.getRunningUrl(),"https://www.demoblaze.com/");
    }
    @When("The User clicks on the Cart Link")
    public void the_user_clicks_on_the_cart_link()
    {
        pom().navBar().clickOnCartLink();
    }
    @Then("The Cart Page should be displayed")
    public void the_cart_page_should_be_displayed()
    {
        utility.assertion.isSameUrl(web.getRunningUrl(),"https://www.demoblaze.com/cart.html");
    }
    @Then("The Cart should be empty")
    public void the_cart_should_be_empty()
    {
       utility.assertion.isElementEmpty(pom().cartPage().getAllCartItems());
    }



    @When("The User adds one item to cart")
    public void the_user_adds_one_item_to_cart()
    {
       pom().homePage().selectDesiredItem("Samsung galaxy s6");

       pom().productDetail().clickOnAddToCartButton();
       pom().productDetail().acceptAlert();



    }


    @Then("The Product should be visible in the Cart")
    public void the_product_should_be_visible_in_the_cart()
    {
//        hooks.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Cart']")))
//                .click();
//
//        List<WebElement> allCartPageOptions= hooks.wait.until(ExpectedConditions.visibilityOfAllElements(hooks.web.getDriver().findElements(By.xpath("//tr[@class='success']"))));
//
//        for(WebElement element:allCartPageOptions)
//        {
//            WebElement elementVisibilityStatus= hooks.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='success']")));
//
//            Assert.assertTrue(elementVisibilityStatus.isDisplayed(),"The element is not displayed in Cart Page");
//            Reporter.log("The element is displayed in Cart Page",true);
//
//        }

        web.refreshPage();
        pom().navBar().clickOnCartLink();


        utility.assertion.isElementCountSame(pom().cartPage().getAllCartItems(),1);
    }




    @When("The User adds two items to cart")
    public void the_user_adds_two_items_to_cart()
    {
        pom().homePage().selectDesiredItem("Nokia lumia 1520");
        pom().productDetail().clickOnAddToCartButton();
        pom().productDetail().acceptAlert();

        pom().navBar().clickOnHomeLink();

        pom().homePage().selectDesiredItem("Nexus 6");
        pom().productDetail().clickOnAddToCartButton();
        pom().productDetail().acceptAlert();
    }


    @Then("The Two Products should be visible in the Cart")
    public void the_two_products_should_be_visible_in_the_cart()
    {
//        web.refreshPage();

        pom().navBar().clickOnCartLink();

        utility.assertion.isElementCountSame(pom().cartPage().getAllCartItems(),2);
    }


}
