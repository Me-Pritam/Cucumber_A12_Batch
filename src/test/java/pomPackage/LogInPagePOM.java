package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPagePOM
{
    @FindBy(xpath = "//input[@id='loginusername']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@id='loginpassword']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement logInButton;


    public LogInPagePOM(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void performLogIn(String userName, String password)
    {
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        logInButton.click();
    }
}
