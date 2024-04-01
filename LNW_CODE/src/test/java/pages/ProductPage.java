package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	private WebDriver driver;

	@FindBy(id = "add-to-cart-button")
	private WebElement addToCartButton;

	@FindBy(xpath = "//span[@id='priceblock_ourprice']")
	private WebElement productPrice;
	@FindBy(xpath = "(//span[@id='priceblock_ourprice'])[2]")
	private WebElement secondproductPrice;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void addProductToCart() {
		addToCartButton.click();
	}

	public double getsecondproductPrice() {
		String price = secondproductPrice.getText();
		return Double.parseDouble(price.substring(1).replace(",", ""));
	}

	public double getProductPrice() {
		String price = productPrice.getText();
		return Double.parseDouble(price.substring(1).replace(",", ""));
	}

	public CartPage goToCartPage() {
		WebElement cartLink = driver.findElement(By.xpath("//span[@id='nav-cart-count']/a"));
		cartLink.click();
		return new CartPage(driver);
	}

}