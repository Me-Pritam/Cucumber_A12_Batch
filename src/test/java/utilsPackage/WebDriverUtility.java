package utilsPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverUtility
{
    public WebDriverUtility()
    {

    }

    ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

    public void openBrowser(String browser)
    {
        switch (browser.toLowerCase())
        {
            case "chrome":
                tlDriver.set(new ChromeDriver());
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver","./BrowserDrivers/msedgedriver.exe");
                tlDriver.set(new EdgeDriver());
                break;
            case "firefox":
                tlDriver.set(new FirefoxDriver());
                break;
        }


    }

    public WebDriver getDriver()
    {
        return tlDriver.get();
    }

    public void openURL(String url)
    {
        getDriver().get(url);
    }

    public void maximizeBrowser()
    {
        getDriver().manage().window().maximize();
    }

    public void waitForElement(int num)
    {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(num));
    }

    public String getRunningUrl()
    {
        return getDriver().getCurrentUrl();
    }

    public void goBackToOldPage()
    {
        getDriver().navigate().back();
    }

    public WebElement applyExtraWaitForElement(WebElement element, long time)
    {
        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void refreshPage()
    {
        getDriver().navigate().refresh();
    }
}
