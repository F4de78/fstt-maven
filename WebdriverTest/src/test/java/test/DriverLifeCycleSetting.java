package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverLifeCycleSetting {
	
	protected WebDriver driver;
	
	@BeforeAll
	public static void beforeAll() { WebDriverManager.chromedriver().setup(); }

	@BeforeEach
	public void beforeEach() { 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options); 
	}
	
	@AfterEach 
	public void afterEch() {
		if (driver != null) driver.quit();
	}
}