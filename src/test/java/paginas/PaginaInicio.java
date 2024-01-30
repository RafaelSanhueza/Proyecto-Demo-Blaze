package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PaginaInicio {
	@FindBy(css = "#signin2")
	WebElement btnSignUp;
	@FindBy(css = "#sign-username")
	WebElement txtUserSignUp;
	@FindBy(css = "#sign-password")
	WebElement txtPassSignUp;
	@FindBy(xpath = "//button[contains(text(),'Sign up')]")
	WebElement btnSignInTwo;
	@FindBy(css = "#login2")
	WebElement btnLogin;
	@FindBy(css = "#loginusername")
	WebElement txtUserLogin;
	@FindBy(css = "#loginpassword")
	WebElement txtPassLogin;
	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	WebElement btnLoginTwo;
	@FindBy(xpath = "//body/div[@id='signInModal']/div[1]/div[1]/div[3]/button[1]")
	WebElement btnClose;
	
	public PaginaInicio (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void botonSignUp() {
		btnSignUp.click();
	}
	
	public void crearCuenta() throws InterruptedException {
		txtUserSignUp.sendKeys("usuariopruebasdemoblaze");
		txtPassSignUp.sendKeys("password6");
		btnSignInTwo.click();
	}
	
	public void btnClose() {
		btnClose.click();
	}
	
	public void botonLogin() {
		btnLogin.click();
	}
	
	public void hacerLogin() throws InterruptedException {
		txtUserLogin.sendKeys("usuariopruebasdemoblaze");
		txtPassLogin.sendKeys("password6");
		btnLoginTwo.click();
	}
}
