package pomPackage;

import org.openqa.selenium.WebDriver;

public class POMFactory
{



    public WebDriver driver;


    public POMFactory(WebDriver driver)
    {
        this.driver = driver;
    }

    public HomePagePOM homePage()
    {
        return new HomePagePOM(driver);
    }

    public NavBarPOM navBar()
    {
        return new NavBarPOM(homePage().accessNavBar());

    }

    public LogInPagePOM logInPage()
    {
        return new LogInPagePOM(driver);
    }

    public CartPagePOM cartPage()
    {
        return new CartPagePOM(driver);
    }

    public ProductDetailPagePOM productDetail()
    {
        return new ProductDetailPagePOM(driver);
    }


}
