package Test;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaCarrito;
import paginas.PaginaInicio;
import paginas.PaginaPrincipal;
import utilidades.CapturarEvidencia;

public class Pruebas {
	String url = "https://www.demoblaze.com/";
	String directorioEvidencias = "..\\Demoblaze\\Evidencia\\";
	String nombreDocumento = "Evidencias de Prueba Demoblaze.docx";
	WebDriver driver;
	
	@BeforeSuite
	public void setup() {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test(description="CP01 - Crear Cuenta", priority = 1)
	public void signUp() throws InterruptedException, IOException, InvalidFormatException {
		PaginaInicio inicio = new PaginaInicio(driver);
		
		//Escribir título del documento
		CapturarEvidencia.escribirTitutloDocumento(directorioEvidencias + nombreDocumento, "Documento Evidencia Automatización Demoblaze", 20);
		
		CapturarEvidencia.capturarPantallaEnDocumento(driver, directorioEvidencias + "img.jpg", directorioEvidencias + nombreDocumento, "Pantalla 1.- Principal Page");
		inicio.botonSignUp();
		
		CapturarEvidencia.capturarPantallaEnDocumento(driver, directorioEvidencias + "img.jpg", directorioEvidencias + nombreDocumento, "Pantalla 2.- Login");
		
		WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(30));
		espera.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sign-username")));
		
		inicio.crearCuenta();
		CapturarEvidencia.capturarPantallaEnDocumento(driver, directorioEvidencias + "img.jpg", directorioEvidencias + nombreDocumento, "Pantalla 3.- Create new account");
		
		
		Thread.sleep(2000);
		driver.switchTo().alert().accept();	
		
		inicio.btnClose();
	}
	
	@Test(description="CP02 - Login", priority = 2)
	public void login() throws InterruptedException, InvalidFormatException, IOException {
		PaginaInicio inicio1 = new PaginaInicio(driver);
		inicio1.botonLogin();
		CapturarEvidencia.capturarPantallaEnDocumento(driver, directorioEvidencias + "img.jpg", directorioEvidencias + nombreDocumento, "Pantalla 4.- Login");
		
		WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(30));
		espera.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#loginusername")));
		
		inicio1.hacerLogin();
		CapturarEvidencia.capturarPantallaEnDocumento(driver, directorioEvidencias + "img.jpg", directorioEvidencias + nombreDocumento, "Pantalla 5.- Login Exitoso");
		
		driver.switchTo().alert().accept();
	}
	
	@Test(description="CP03 - Agregar producto al carrito", priority = 3)
	public void agregarProductoCarro () throws InterruptedException, InvalidFormatException, IOException {
		WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(90));
		espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Samsung galaxy s6')]")));
		
		PaginaPrincipal pagina = new PaginaPrincipal(driver);
		pagina.agregarProducto();
		CapturarEvidencia.capturarPantallaEnDocumento(driver, directorioEvidencias + "img.jpg", directorioEvidencias + nombreDocumento, "Pantalla 6.- Product added");
		
		driver.switchTo().alert().accept();
	}
	
	@Test(description="CP03 - Realizar compra", priority = 4)
	public void realizarCompra () throws InterruptedException, InvalidFormatException, IOException {
		PaginaCarrito carrito = new PaginaCarrito(driver);
		
		carrito.irAlCarrito();
		CapturarEvidencia.capturarPantallaEnDocumento(driver, directorioEvidencias + "img.jpg", directorioEvidencias + nombreDocumento, "Pantalla 7.- Go cart");
		
		WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(90));
		espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Place Order')]")));
		
		carrito.botonPlaceOrder();
		CapturarEvidencia.capturarPantallaEnDocumento(driver, directorioEvidencias + "img.jpg", directorioEvidencias + nombreDocumento, "Pantalla 8.- Place Order");
		
		WebDriverWait espera1 = new WebDriverWait(driver, Duration.ofSeconds(90));
		espera.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#name")));
		
		carrito.realizarCompra();
		CapturarEvidencia.capturarPantallaEnDocumento(driver, directorioEvidencias + "img.jpg", directorioEvidencias + nombreDocumento, "Pantalla 9.- Do buy");
		
		WebDriverWait espera2 = new WebDriverWait(driver, Duration.ofSeconds(90));
		espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'OK')]")));
		
		carrito.botonOK();
		CapturarEvidencia.capturarPantallaEnDocumento(driver, directorioEvidencias + "img.jpg", directorioEvidencias + nombreDocumento, "Pantalla 10.- Button OK");
		
		carrito.logOut();
		CapturarEvidencia.capturarPantallaEnDocumento(driver, directorioEvidencias + "img.jpg", directorioEvidencias + nombreDocumento, "Pantalla 11.- Log Out");
		
		driver.close();
	}
	
}
