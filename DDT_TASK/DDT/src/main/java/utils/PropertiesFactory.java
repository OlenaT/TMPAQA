package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.lang.Thread.currentThread;

public class PropertiesFactory {

    private static final String TEST_PROPERTIES = "test.properties";

    /**
     * Instantiates a new Properties utils.
     */
    public PropertiesFactory(){}

    /**
     * Get property.
     * @param property property
     * @return property
     */
    public static String getProperty(String property) {
        Properties prop = new Properties();
        ClassLoader loader = currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream(TEST_PROPERTIES);
        try {
            prop.load(stream);
        } catch (IOException e) {
            return e.getMessage();
        }
        return prop.getProperty(property);
    }
}
