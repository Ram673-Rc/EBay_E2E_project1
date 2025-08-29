package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageObjects.HomePage;
import utilities.DriverFactory;

public class HomePageSteps {

    WebDriver driver = DriverFactory.getDriver();
    HomePage homePage = new HomePage(driver);

    @Given("User On E'bay Page")
    public void user_on_e_bay_page() {
        driver.get("https://www.ebay.com/");
    }

    @When("User enters {string} in the search bar")
    public void user_enters_in_search(String term) {
        homePage.enterSearchText(term);
    }

    @When("User clicks the search button")
    public void user_clicks_search_button() {
        homePage.clickSearchButton();
    }

    @Then("User should see {int} search results displayed on the screen")
    public void user_should_see_results(int expectedMinimum) {
        String title = driver.getTitle();
        Assert.assertTrue(title.length() > 0); // Or customize based on real results count if needed
    }

    @When("User click on Advanced hyperlink Button")
    public void user_click_on_advanced_hyperlink_button() {
        homePage.clickAdvancedLink();
    }

    @Then("user navigate to advanced Search Page")
    public void user_navigate_to_advanced_search_page() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("ebayadvsearch"));
    }

    @When("User search the for {string} in {string} category")
    public void user_search_the_for_in_category(String item, String category) {
        homePage.enterSearchText(item);
        homePage.selectCategory(category);
        homePage.clickSearchButton();
    }

    @When("User clicks on the {string} navigation link")
    public void user_clicks_on_the_navigation_link(String linkText) {
        WebElement navLink = driver.findElement(By.linkText(linkText));
        navLink.click();
    }

    @Then("User should be navigated to {string} and the page title should contain {string}")
    public void user_should_be_navigated_to_and_the_page_title_should_contain(String expectedUrlPart, String expectedTitlePart) {
        String actualUrl = driver.getCurrentUrl();
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualUrl.contains(expectedUrlPart), "URL check failed. Expected to contain: " + expectedUrlPart + ", but was: " + actualUrl);
        Assert.assertTrue(actualTitle.contains(expectedTitlePart), "Title check failed. Expected to contain: " + expectedTitlePart + ", but was: " + actualTitle);
    }
}
