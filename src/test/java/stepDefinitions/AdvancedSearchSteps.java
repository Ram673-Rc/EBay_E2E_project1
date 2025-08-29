package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import PageObjects.AdvancedSearchPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DriverFactory;

public class AdvancedSearchSteps {

    AdvancedSearchPage advancedPage;

    @Given("User Ebay Advanced Search Page")
    public void user_ebay_advanced_search_page() {
        DriverFactory.getDriver().get("https://www.ebay.com/sch/ebayadvsearch");
        advancedPage = new AdvancedSearchPage(DriverFactory.getDriver());
    }

    @When("User click the Ebay logo")
    public void user_click_the_ebay_logo() {
        advancedPage.clickEbayLogo();
    }

    @Then("User Back to the Ebay Home page")
    public void user_back_to_the_ebay_home_page() {
        Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("ebay.com"));
    }

    @When("User Search the items")
    public void user_search_the_items(DataTable dataTable) {
        List<Map<String, String>> searchData = dataTable.asMaps(String.class, String.class);

        String keyword = searchData.get(0).get("Keyword");
        String exclude = searchData.get(0).get("Exclude");
        String minPrice = searchData.get(0).get("Min Price");
        String maxPrice = searchData.get(0).get("Max Price");

        advancedPage.fillAdvancedSearch(keyword, exclude, minPrice, maxPrice);
        advancedPage.clickSearch();
    }
}
