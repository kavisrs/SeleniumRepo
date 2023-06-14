package second.marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class AdministratorCertifications {

	public static void main(String[] args) throws InterruptedException, IOException {
		EdgeOptions option = new EdgeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		EdgeDriver driver = new EdgeDriver();
		
//		ChromeOptions option = new ChromeOptions();
//		option.addArguments("--disable-notifications");
//		ChromeDriver driver=new ChromeDriver(option); 
		
		
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
		System.out.println("Total number of windows: " +windowHandles.size());
		List<String> fsthandle = new ArrayList<String>(windowHandles);
		driver.switchTo().window(fsthandle.get(1));
		
		//Click confirm on Confirm redirect
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		Thread.sleep(4000);
		//Click Learning 
		Shadow dom = new Shadow(driver);
		dom.findElementByXPath("//span[text()='Learning']").click();
		dom.setImplicitWait(20);
		
		//And mouse hover on Learning On Trailhead
		WebElement element = dom.findElementByXPath("//span[text()='Learning on Trailhead']");
		
		Actions builder = new Actions(driver);
		builder.moveToElement(element).perform();
		
		//Click on Salesforce Certifications
		WebElement element2 = dom.findElementByXPath("//a[text()='Salesforce Certification']");
		builder.scrollToElement(element2).perform();
		element2.click();
		
		//Click on first resulting Ceritificate
		driver.findElement(By.xpath("//a[text()='Administrator']")).click();
		
		//verify administrator overview page
		String currentURL = driver.getCurrentUrl();
		System.out.println("Current URL is:  " +currentURL);
		
		//print the certification available for Administrator certification
		List<WebElement> certificationList = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		System.out.println("Total no of certifcations: " +certificationList.size());
					
		for (int i = 0; i < certificationList.size(); i++) {
			String text = certificationList.get(i).getText();
			System.out.println(text);	
		}
		
		//Take a Snapshot of Certifications
		WebElement snapEle = driver.findElement(By.xpath("//a[text()='Strategy Designer']"));
		Actions builder1 = new Actions(driver);
		builder1.scrollToElement(snapEle).perform();
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./snaps/AdminCertification.png");
		FileUtils.copyFile(source, destination);
		
		
		
		
		

	}

}
