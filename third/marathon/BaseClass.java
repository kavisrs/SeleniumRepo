package third.marathon;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class BaseClass {

	ChromeDriver driver;
	String ExcelFileName;

	@BeforeMethod()
	public void preCondition() throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver = new ChromeDriver(option);

		//Launch https://login.salesforce.com/ 
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Log in to Salesforce with your username and password
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		driver.findElement(By.id("Login")).click();

		//Click on the App Launcher (dots)
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		//Click View All
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();	
	}

	@AfterMethod()
	public void afterCondition() {
		//driver.quit();
	}

	@DataProvider()
	public String[][] sendData() throws IOException {
		return MarathonThreeReadExcel.readexcelMarathonThree(ExcelFileName);


	}
}
