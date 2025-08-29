package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Advanced")
    private WebElement advancedLink;

    @FindBy(id = "gh-ac")
    private WebElement searchBar;

    @FindBy(id = "gh-search-btn")
    private WebElement searchButton;

    @FindBy(id = "gh-cat")
    private WebElement categoryDropdown;

    public void clickAdvancedLink() {
        advancedLink.click();
    }

    public void enterSearchText(String product) {
        searchBar.clear();
        searchBar.sendKeys(product);
    }

    public void selectCategory(String categoryName) {
        Select select = new Select(categoryDropdown);
        select.selectByVisibleText(categoryName);
    }

    public void clickSearchButton() {
        searchButton.click();
    }
}
