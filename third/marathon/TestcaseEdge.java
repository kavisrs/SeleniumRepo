package third.marathon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestcaseEdge extends BaseClass {
	
	@Test
	public void edgeTest() {
		//Click View All and click Sales from App Launcher
		driver.findElement(By.xpath("//span/p[text()='Sales']")).click();
				
		//Key Deals in Key Deals 
		WebElement allKeyDealsElement = driver.findElement(By.xpath("//span[text()='View All Key Deals']"));
		driver.executeScript("arguments[0].click();", allKeyDealsElement);
		
		
		//Click on New
		driver.findElement(By.linkText("New")).click();
		
		
		//Give Opportunity Name  (From Excel)
		driver.findElement(By.xpath("(//input[@class='slds-input'])[4]")).sendKeys("test");
		
		//Select Type as New Customer and Lead Source as Partner Referral
		WebElement typeElement = driver.findElement(By.xpath("(//span[@part='boundary']/lightning-primitive-icon)[40]"));
		driver.executeScript("arguments[0].click();", typeElement); //ElementClickInterceptedException-hence stored xpath to a variable and used JavaScript
		driver.findElement(By.xpath("//span[text()='New Customer']")).click();
		
		WebElement leadSourceElement = driver.findElement(By.xpath("(//span[@part='boundary']/lightning-primitive-icon)[42]"));
		driver.executeScript("arguments[0].click();", leadSourceElement); //ElementClickInterceptedException-hence stored xpath to a variable and used JavaScript
		driver.findElement(By.xpath("//span[text()='Partner Referral']")).click();
		
		//Give the Amount as 75000 (from Excel)
		driver.findElement(By.xpath("//div/input[@name='Amount']")).sendKeys("75000");
		
		//Select the Close Date as tomorrow
		WebElement dateElement = driver.findElement(By.xpath("//span[text()='Select a date for Close Date']"));
		driver.executeScript("arguments[0].click();", dateElement);
		driver.findElement(By.xpath("//tr/td/span[text()='22']")).click();
		
		//Select Stage as Needs Analysis
		WebElement stageElement = driver.findElement(By.xpath("(//div/lightning-icon[@icon-name=\"utility:down\"])[2]"));
		driver.executeScript("arguments[0].click();", stageElement);
		driver.findElement(By.xpath("//div/lightning-base-combobox-item[4]/span/span[text()='Needs Analysis']")).click();
		
		//Click on Primary Campaign  Source and Select the first option
		WebElement campaignElement = driver.findElement(By.xpath("(//div/lightning-icon[@icon-name='utility:search'])[2]"));
		driver.executeScript("arguments[0].click();", campaignElement);
		driver.findElement(By.xpath("//span/lightning-icon[@icon-name='standard:campaign']/span/lightning-primitive-icon")).click();
		
		//Click Save and Verify the opportunity is created"
		driver.findElement(By.xpath("//lightning-button/button[text()='Save']")).click();
		
		
		
		
		
		
	}

}
