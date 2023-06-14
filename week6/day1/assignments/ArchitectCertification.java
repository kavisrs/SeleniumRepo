package week6.day1.assignments;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;


public class ArchitectCertification extends BaseClass {
	@Test(timeOut = 100000)
	public void archCerti() throws IOException{

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
