package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaCarrito {
	@FindBy(xpath = "//button[contains(text(),'Place Order')]")
	WebElement btnPlaceOrder;
	@FindBy(linkText = "Delete")
	WebElement linkDelete;
	@FindBy(css = "#name")
	WebElement txtName;
	@FindBy(css = "#country")
	WebElement txtCountry;
	@FindBy(css = "#city")
	WebElement txtCity;
	@FindBy(css = "#card")
	WebElement txtCreditCard;
	@FindBy(css = "#month")
	WebElement txtMonth;
	@FindBy(css = "#year")
	WebElement txtYear;
	@FindBy(xpath = "//button[contains(text(),'Purchase')]")
	WebElement btnPurchase;
	@FindBy(css = "#cartur")
	WebElement btnCart;
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement btnOK;
	@FindBy(css = "#logout2")
	WebElement btnLogOut;
	
	public PaginaCarrito (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void irAlCarrito() {
		btnCart.click();
	}
	
	public void botonPlaceOrder() {
		btnPlaceOrder.click();
	}
	
	public void realizarCompra() throws InterruptedException {
		txtName.sendKeys("Rafael Sanhueza");
		txtCountry.sendKeys("Chile");
		txtCity.sendKeys("Santiago");
		txtCreditCard.sendKeys("0998123476492945");
		txtMonth.sendKeys("Enero");
		txtYear.sendKeys("2024");
		btnPurchase.click();
		Thread.sleep(2000);
	}
	
	public void botonOK() {
		btnOK.click();
	}
	
	public void logOut() {
		btnLogOut.click();
	}
}
