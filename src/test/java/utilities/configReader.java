package utilities;

import java.io.InputStream;
import java.util.Properties;

public class configReader {
    private static Properties prop;

    public static Properties initProperties() {
        prop = new Properties();
        try {
            // Load using classloader (works correctly for resources folder)
            InputStream input = configReader.class.getClassLoader().getResourceAsStream("config.properties");
            if (input == null) {
                throw new RuntimeException("config.properties file not found in resources folder");
            }
            prop.load(input);
        } catch (Exception e) {
            System.out.println("Error loading config.properties: " + e.getMessage());
        }
        return prop;
    }

    public static String getProperty(String key) {
        if (prop == null) {
            initProperties();
        }
        return prop.getProperty(key);
    }
}
