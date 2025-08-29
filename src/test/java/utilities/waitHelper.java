//package utilities;
//import java.time.Duration;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//public class waitHelper {
//	WebDriver driver;
//	
//	public waitHelper(WebDriver driver) {
//	    this.driver = driver;
//	}
//
//	public void waitForElementToBeVisible(WebElement element, int timeoutInSeconds) {
//	    new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
//	        .until(ExpectedConditions.visibilityOf(element));
//	}
//
//	public void waitForElementToBeClickable(WebElement element, int timeoutInSeconds) {
//	    new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
//	        .until(ExpectedConditions.elementToBeClickable(element));
//	}
//}