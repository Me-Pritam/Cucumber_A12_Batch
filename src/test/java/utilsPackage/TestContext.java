package utilsPackage;



import org.openqa.selenium.WebDriver;
import pomPackage.POMFactory;

public class TestContext {

    private WebDriver driver;
    private POMFactory pomFactory;

    // ===== Blank Constructor ====
    public TestContext()
    {

    }

    // ===== WebDriver =====
    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    // ===== POM Factory =====
    public POMFactory getPomFactory() {
        if (pomFactory == null) {
            pomFactory = new POMFactory(driver);
        }
        return pomFactory;
    }
}

