package pomPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPagePOM
{
    WebDriver driver;

    @FindBy(xpath = "//table[contains(@class,'table table-bordered table-hover table-striped')]/child::tbody/child::tr")
    private List<WebElement> allCartItems;

    @FindBy(xpath = "//button[text()='Place Order']")
    private WebElement placeOrderButton;

    @FindBy(xpath = "//h3[@id='totalp']")
    private WebElement totalPrice;

    public CartPagePOM(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public List<WebElement> getAllCartItems()
    {
        return allCartItems;
    }

    public void deleteItemFromCartUsingName(String itemName)
    {
        for(WebElement element : allCartItems)
        {
            String elementName= element.findElement(By.xpath("/child::td[2]")).getText();

            if (elementName.equals(itemName))
            {
                element.findElement(By.xpath("/child::td[4]/child::a")).click();
                break;

            }
        }
    }


    public void clickOnPlaceOrderButton()
    {
        placeOrderButton.click();
    }

    public String getTotalPrice()
    {
        return totalPrice.getText();
    }
}
