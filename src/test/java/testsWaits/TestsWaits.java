package testsWaits;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestsWaits {
	
	WebDriver driver;
	String PATH_DRIVER ="C:\\Users\\MI PC\\Documents\\Workspace Softesting\\MiPrimerProyectoSelenium\\src\\test\\resources\\webDriver\\chromedriver.exe";
	String TIPO_DRIVER="webdriver.chrome.driver";
	String URL="https://the-internet.herokuapp.com/dynamic_loading/2";
	
	@Before
	public void setUp() {
		System.setProperty(TIPO_DRIVER, PATH_DRIVER);
		driver=new ChromeDriver();
		driver.get(URL);
		
		//ESPERA IMPLÍCITA
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
		
//	@Test
//	public void testSinWait(){
//		
//		//Paso 1: CLICK EN EL BOTÓN START
//		WebElement btnStart= driver.findElement(By.xpath("//*[@id='start']/button"));
//		btnStart.click();
//		//PASO 2: VALIDAR EL TEXTO
//		WebElement txtSaludo	 = driver.findElement(By.xpath("//*[@id='finish']/h4"));
//		Assert.assertEquals("Hello World!",txtSaludo.getText());
//		
//		
//	}
	
//	@Test
//	public void testConExplicitWait(){
//		
//		By localizadorTxtSaludo = By.xpath("//*[@id='finish']/h4");
//		//Paso 1: CLICK EN EL BOTÓN START
//		WebElement btnStart= driver.findElement(By.xpath("//*[@id='start']/button"));
//		btnStart.click();
//		//PASO 2: VALIDAR EL TEXTO
//		WebDriverWait esperaExplícita = new WebDriverWait(driver, 5);
//		
//		//ESPERA EXPLÍCITA
//		esperaExplícita.until(ExpectedConditions.visibilityOfElementLocated(localizadorTxtSaludo));
//		WebElement txtSaludo	 = driver.findElement(By.xpath("//*[@id='finish']/h4"));
//		 
//		Assert.assertEquals("Hello World!",txtSaludo.getText());
//		
//		
//	}
	
	@Test//USANTO FLUENTWAIT
	public void testConExplicitFluentWait(){
		
		final By localizadorTxtSaludo = By.xpath("//*[@id='finish']/h4");
		//Paso 1: CLICK EN EL BOTÓN START
		WebElement btnStart= driver.findElement(By.xpath("//*[@id='start']/button"));
		btnStart.click();
		
		//ESPERA FluentWait
		Wait<WebDriver> esperaFluida = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class);
		//esperaFluida.until(ExpectedConditions.visibilityOfElementLocated(localizadorTxtSaludo));
		
		esperaFluida.until(new Function<WebDriver,WebElement>(){

			public WebElement apply(WebDriver driver) {

				return driver.findElement(localizadorTxtSaludo);
			}
			
			
		});
		
		
		//PASO 2: VALIDAR EL TEXTO
		WebElement txtSaludo	 = driver.findElement(By.xpath("//*[@id='finish']/h4"));
		 
		Assert.assertEquals("Hello World!",txtSaludo.getText());
		
		
	}
	
	
	
	@After
	public void tearDown() {
		driver.quit();
		
	}
	
	

}
