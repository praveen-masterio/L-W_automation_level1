package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	private WebDriver driver;

	@FindBy(xpath = "//span[@class='a-price-whole']")
	private WebElement price;

	@FindBy(xpath = "//span[@class='a-color-base subtotal-price']")
	private WebElement subTotal;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getPrice() {
		return price.getText();
	}

	public String getSubTotal() {
		return subTotal.getText();
	}

}