package utilsPackage;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.List;

public class AssertionUtility
{
    public void isSameUrl(String actual,String expected)
    {
        Assert.assertEquals(actual,expected,"The Urls are not same");

        Reporter.log("The Urls are same",true);
    }

    public void isSameText(String actual, String expected)
    {
        Assert.assertEquals(actual,expected,"The Texts are different");

        Reporter.log("The texts are same",true);
    }

    public void isElementEmpty(List<WebElement> allElement)
    {
        Assert.assertTrue(allElement.isEmpty(),"The elements are present");

        Reporter.log("The Elements are not there",true);
    }

    public void isElementCountSame(List<WebElement> allElements, int num)
    {
        Assert.assertEquals(allElements.size(),num,"The element count is different");
        Reporter.log("The Element Count is Same",true);
    }
}
