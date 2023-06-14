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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class ArchitectCertification {

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
		//System.out.println("Total number of windows: " +windowHandles.size());
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

		//Choose Your Role as Salesforce Architect
		driver.findElement(By.xpath("//div[text()='Architect']")).click();

		//Get the Text(Summary) of Salesforce Architect
		WebElement paragraphElement = driver.findElement(By.xpath("//div[contains(@class,'slds-container--center slds-p-bottom--large')]"));		
		String text = paragraphElement.getText();
		System.out.println(text);

		//Get the List of Salesforce Architect Certifications Available
		List<WebElement> archCertiList = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		System.out.println("Total number of certifications under Architect :  "+archCertiList.size());

		for (int i = 0; i < archCertiList.size(); i++) {
			String text1 = archCertiList.get(i).getText();
			System.out.println(text1);
		    }

		//Click on Application Architect 
		driver.findElement(By.xpath("//div/a[text()='Application Architect']")).click();
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Certification in Application Architect page:");

		//Get the List of Certifications available
		List<WebElement> archList = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		for (int i = 0; i < archList.size(); i++) {
			String text2 = archList.get(i).getText();
			System.out.println(text2);
			}

		//Take a Snapshot of Certifications.
		WebElement printscroll = driver.findElement(By.xpath("//a[text()='Platform App Builder']"));
		Actions act = new Actions(driver);
		act.scrollToElement(printscroll).perform();

		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./snaps/ArchCertification.png");
		FileUtils.copyFile(source, destination);

	}
}
