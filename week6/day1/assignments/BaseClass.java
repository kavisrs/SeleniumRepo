package week6.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	EdgeDriver driver;

	@BeforeMethod
	public void precondition() throws InterruptedException {
		//		EdgeOptions option = new EdgeOptions();
		//		option.addArguments("--remote-allow-origins=*");
		//		option.addArguments("--disable-notifications");
	
		//		ChromeOptions option = new ChromeOptions();
		//		option.addArguments("--disable-notifications");
		//		ChromeDriver driver=new ChromeDriver(option);

		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		driver.findElement(By.id("Login")).click();
		//Click on Learn More link in Mobile Publisher
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();

		//windwow handles
		Set<String> windowHandles = driver.getWindowHandles();
		//System.out.println("Total number of windows: " +windowHandles.size());
		List<String> fsthandle = new ArrayList<String>(windowHandles);
		driver.switchTo().window(fsthandle.get(1));

		//Click confirm on Confirm redirect
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		Thread.sleep(4000);
	}


	@AfterMethod
	public void aftercondtion() { 
		driver.quit();
	}

}
