package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvancedSearchPage {
    WebDriver driver;

    public AdvancedSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a.gh-logo")
    private WebElement ebayLogo;

    @FindBy(id = "_nkw")
    private WebElement mainKeyword;

    @FindBy(id = "_ex_kw")
    private WebElement excludeKeyword;

    @FindBy(name = "_udlo")
    private WebElement minPrice;

    @FindBy(name = "_udhi")
    private WebElement maxPrice;

    @FindBy(xpath = "//button[contains(text(),'Search')]")
    private WebElement searchButton;

    public void clickEbayLogo() {
        ebayLogo.click();
    }

    public void fillAdvancedSearch(String keyword, String exclude, String min, String max) {
        mainKeyword.clear();
        mainKeyword.sendKeys(keyword);
        excludeKeyword.clear();
        excludeKeyword.sendKeys(exclude);
        minPrice.clear();
        minPrice.sendKeys(min);
        maxPrice.clear();
        maxPrice.sendKeys(max);
    }

    public void clickSearch() {
        searchButton.click();
    }
}
