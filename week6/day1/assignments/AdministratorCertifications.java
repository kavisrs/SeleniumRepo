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

public class AdministratorCertifications extends BaseClass {
	@Test(invocationCount=2)
	public void adminCerti () throws InterruptedException, IOException {

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
