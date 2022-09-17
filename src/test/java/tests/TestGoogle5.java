package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestGoogle5 {
	
	private WebDriver driver;
	private static final String TIPO_DRIVER="webdriver.chrome.driver";
	private static final String PATH_DRIVER="C:\\Users\\MI PC\\Documents\\Workspace Softesting\\MiPrimerProyectoSelenium\\src\\test\\resources\\webDriver\\chromedriver.exe";
	private String URL= "https://www.google.com";
	
	@BeforeClass
	public static void setBeforeClass() {
		
		System.out.println("INICIO DE TEST");
		System.setProperty(TIPO_DRIVER, PATH_DRIVER);
		}
	
	@Before
	public void setUp() {
		driver= new ChromeDriver();
		driver.get(URL);
	}

	
	@Test
	public void testSourch01() {
		
		boolean value;
		value = driver.findElement(By.xpath("//input[1]")).isEnabled();
		
		System.out.println(value);

	}
	
	
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("FINALIZARON LOS TEST");
	}
	
}
