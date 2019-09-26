package configs;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private static final String pathToProperties = "prop.properties";
    private static Properties property = new Properties();

    public static String getProperty(String properties) {
        String result = null;
        try {
            property.load(PropertyReader.class.getClassLoader().getResourceAsStream(pathToProperties));
            result = property.getProperty(properties);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
