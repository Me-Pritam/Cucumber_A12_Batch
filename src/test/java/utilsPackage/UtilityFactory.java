package utilsPackage;

public class UtilityFactory
{

   public  PropertyFileUtil property ;
   public  WebDriverUtility  webUtil;
   public  AssertionUtility assertion;

    public UtilityFactory()
    {
        property = new PropertyFileUtil();
        webUtil = new WebDriverUtility();
        assertion = new AssertionUtility();
    }
}
