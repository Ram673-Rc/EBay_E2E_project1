package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver initDriver() {
        // Ensure config is loaded before trying to read from it
        configReader.initProperties();

        String browser = configReader.getProperty("browser");

        if (browser == null || browser.isEmpty()) {
            throw new RuntimeException("Browser is not specified in config.properties file.");
        }

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser Value in config.properties: " + browser);
        }

        // Set implicit wait from config
        long timeout = 10; // default
        try {
            timeout = Long.parseLong(configReader.getProperty("implicitWait"));
        } catch (Exception e) {
            System.out.println("Invalid implicit wait in config. Using default 10 seconds.");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
