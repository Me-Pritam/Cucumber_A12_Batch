package pomPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePagePOM
{
    WebDriver driver;

    WebDriverWait wait;

    By navBar = By.xpath("//nav[@id='narvbarx']");

    By phonesLink = By.xpath("//a[text()='Phones']");

    By laptopsLink = By.xpath("//a[text()='Laptops']");

    By monitorsLink = By.xpath("//a[text()='Monitors']");

    By items = By.xpath("//div[@id='tbodyid']/child::div");

    By previousButton = By.xpath("//ul[@class='pagination']/descendant::button[text()='Previous']");

    By nextButton = By.xpath("//ul[@class='pagination']/descendant::button[text()='Next']");

    public HomePagePOM(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement accessNavBar()
    {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(navBar)));
    }

    public void clickOnPhonesLink()
    {
        driver.findElement(phonesLink).click();
    }

    public void clickOnLaptopsLink()
    {
        driver.findElement(laptopsLink).click();
    }

    public void clickOnMonitorsLink()
    {
        driver.findElement(monitorsLink).click();
    }

    public List<WebElement> getAllItems()
    {
        driver.navigate().refresh();

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        List<WebElement> allCartItems= wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(items));

        return allCartItems;
    }

    public void clickOnPreviousButton()
    {
        driver.findElement(previousButton).click();
    }

    public void clickOnNextButton()
    {
        driver.findElement(nextButton).click();
    }



    public WebElement getPhonesLink() {
        return driver.findElement(phonesLink);
    }

    public WebElement getLaptopsLink() {
        return driver.findElement(laptopsLink);
    }

    public WebElement getMonitorsLink() {
        return driver.findElement(monitorsLink);
    }


    public WebElement getPreviousButton() {
        return driver.findElement(previousButton);
    }

    public WebElement getNextButton() {
        return driver.findElement(nextButton);
    }

    public void selectDesiredItem(String name)
    {
        for (WebElement element : getAllItems())
        {
            String prodName=  wait.until(ExpectedConditions.visibilityOf(element.findElement(By.xpath("/descendant::h4[@class='card-title']/child::a")))).getText();
            if (prodName.equals(name))
            {
                element.click();
                break;
            }
        }
    }
}
