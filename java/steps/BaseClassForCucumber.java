package steps;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class BaseClassForCucumber extends AbstractTestNGCucumberTests {
	public static ChromeDriver driver;
	
	@BeforeMethod	 
	public void preContition() {

		driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}

	@AfterMethod
	public void aftercondtion() {
		driver.close();
	}
	
	
	
	
}
