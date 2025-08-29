package stepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DriverFactory;

public class Hooks_Methods {

    private WebDriver driver;

    @Before(order = 0)
    public void setup() {
        driver = DriverFactory.initDriver();
    }

    @After(order = 1)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
