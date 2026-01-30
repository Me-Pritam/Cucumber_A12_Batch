package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailPagePOM
{

    @FindBy(xpath = "//h2[@class='name']")
    private WebElement itemName;

    @FindBy(xpath = "//h3[@class='price-container']")
    private WebElement itemPrice;

    @FindBy(xpath = "//div[@id='more-information']/child::p")
    private WebElement itemDetails;

    @FindBy(xpath = "//a[text()='Add to cart']")
    private WebElement itemAddToCartButton;

    WebDriverWait wait ;

    public ProductDetailPagePOM(WebDriver driver)
    {
        PageFactory.initElements(driver,this);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getItemName()
    {
        return itemName.getText();
    }

    public long getItemPrice()
    {
        return Long.parseLong(itemPrice.getText().replaceAll("[^0-9]",""));
    }

    public String getItemDetails()
    {
        return itemDetails.getText();
    }

    public void clickOnAddToCartButton()
    {

        itemAddToCartButton.click();
    }

    public void acceptAlert()
    {
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

}
