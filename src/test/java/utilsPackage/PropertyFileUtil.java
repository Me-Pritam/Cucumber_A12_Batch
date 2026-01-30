package utilsPackage;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtil
{
    public String getData(String key) throws Exception
    {
        FileInputStream fis = new FileInputStream("./src/test/resources/Config.properties");

        Properties property = new Properties();

        property.load(fis);

        return property.getProperty(key);
    }
}
