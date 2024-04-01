package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchBox;

	@FindBy(id = "nav-search-submit-button")
	private WebElement searchButton;

	@FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
	private WebElement productName;

	public void navigateToHomePage() {
		driver.get("https://www.amazon.in/");
	}

	public void searchForProduct(String product) {
		searchBox.sendKeys(product);
		searchButton.click();
	}

	public ProductPage clickOnFirstProductResult() {
		productName.click();
		return new ProductPage(driver);
	}

	public ProductPage clickOnSecondProductResult() {
		productName.click();
		return new ProductPage(driver);
	}

}