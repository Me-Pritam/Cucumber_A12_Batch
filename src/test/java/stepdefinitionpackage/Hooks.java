package stepdefinitionpackage;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pomPackage.POMFactory;
import utilsPackage.PropertyFileUtil;
import utilsPackage.TestContext;
import utilsPackage.UtilityFactory;
import utilsPackage.WebDriverUtility;

import java.time.Duration;

public class Hooks
{
    public String url;
    public String browser;
    public String user;
    public String password;




    public WebDriverUtility web;
    POMFactory pom;
    TestContext context;

    public Hooks(WebDriverUtility web,TestContext context)
    {
        this.web=web;
        this.context=context;
    }

    @Before(order = 1)
    public void loadData() throws Exception
    {
        PropertyFileUtil pfu = new PropertyFileUtil();
        browser = pfu.getData("browser");
        url = pfu.getData("url");
        user = pfu.getData("user");
        password = pfu.getData("password");

       web.openBrowser(browser);
       web.openURL(url);
       web.maximizeBrowser();
       web.waitForElement(10);

       context.setDriver(web.getDriver());

       pom = context.getPomFactory();



    }

   @Before(value = "@OneItem",order = 2)
    public void doLogIn()
   {
        pom.navBar().clickOnLogInLink();
        pom.logInPage().performLogIn("demomail12@gmail.com","Password@1234");

   }
}
