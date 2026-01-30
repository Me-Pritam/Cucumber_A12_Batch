package pomPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NavBarPOM
{
    WebElement navBar;

    public NavBarPOM(WebElement navBar)
    {
        this.navBar = navBar;
    }

    By productStoreLink = By.xpath("//a[@id='nava']");

    By homeLink = By.xpath("//a[contains(text(),'Home')]");

    By contactLink = By.xpath("//a[contains(text(),'Contact')]");

    By aboutUsLink = By.xpath("//a[contains(text(),'About us')]");

    By cartLink = By.xpath("//a[contains(text(),'Cart')]");

    By logInLink = By.xpath("//a[contains(text(),'Log in')]");

    By signUpLink = By.xpath("//a[contains(text(),'Sign up')]");

    By logOutLink = By.xpath("//a[contains(text(),'Log out')]");

    By userNameLink = By.xpath("//a[@id='nameofuser']");


    public void clickOnHomeLink()
    {
        navBar.findElement(homeLink).click();
    }

    public void clickOnContactLink()
    {
        navBar.findElement(contactLink).click();
    }

    public void clickOnAboutUsLink()
    {
        navBar.findElement(aboutUsLink).click();
    }

    public void clickOnCartLink()
    {
         navBar.findElement(cartLink).click();
    }

    public void clickOnLogInLink()
    {
        navBar.findElement(logInLink).click();
    }

    public void clickOnSignUpLink()
    {
        navBar.findElement(signUpLink).click();
    }

    public void clickOnLogOutLink()
    {
        navBar.findElement(logOutLink).click();
    }

    public void clickOnuserNameLink()
    {
        navBar.findElement(userNameLink).click();
    }

    public WebElement getCartLink()
{
    return navBar.findElement(cartLink);
}
}
