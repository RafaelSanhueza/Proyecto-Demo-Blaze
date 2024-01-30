package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaPrincipal {
	@FindBy(xpath = "//a[contains(text(),'Samsung galaxy s6')]")
	WebElement lnkCelularUno;
	@FindBy(linkText = "Contact")
	WebElement btnContact;
	@FindBy(linkText = "Add to cart")
	WebElement btnAddToCart;
	@FindBy(linkText = "Phones")
	WebElement btnPhones;
	@FindBy(css = "#cartur")
	WebElement btnCart;
	
	public PaginaPrincipal (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void agregarProducto() throws InterruptedException {
		Thread.sleep(2000);
		lnkCelularUno.click();
		Thread.sleep(2000);
		btnAddToCart.click();
		Thread.sleep(2000);
	}
}
