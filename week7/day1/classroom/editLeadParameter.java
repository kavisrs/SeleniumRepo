package week7.day1.classroom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class editLeadParameter extends baseClass {
	@Test(dataProvider = "sendData")
	
	public void runEditLead(String pNo, String cName) throws InterruptedException {
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(pNo);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		WebElement companyName = driver.findElement(By.id("updateLeadForm_companyName"));
		companyName.clear();
		companyName.sendKeys(cName);
		driver.findElement(By.name("submitButton")).click();
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (text.contains("TCS")) {
			System.out.println("Lead is editted successfully");
		}
		else {
			System.out.println("Lead is not editted");
		}




	}
@DataProvider
	public String[][] sendData() {
		//creating 2 dimensional array
		String[][] data = new String[4][2];
		
		//data 1
		data[0][0] = "99";
		data[0][1] = "TCS";
		
		//data2
		data[1][0] = "96";
		data[1][1] = "CTS";
		
		//data3
		data[2][0] = "98";
		data[2][1] = "INFOSYS";
		
		//data4
		data[3][0] = "97";
		data[3][1] = "WIPRO";
		return data;
	}

}
