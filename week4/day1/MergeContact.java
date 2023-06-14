//Launch URL "http://leaftaps.com/opentaps/control/login"  -  Enter UserName and Password Using Id Locator
//Click on Login Button using Class Locator  -  Click on CRM/SFA Link
//Click on contacts Button  -  Click on Merge Contacts using Xpath Locator
//Click on Widget of From Contact  -  Click on First Resulting Contact
//Click on Widget of To Contact  -  Click on Second Resulting Contact
//Click on Merge button using X path Locator  -  Accept the Alert
//Verify the title of the page


package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class MergeContact {

	public static void main(String[] args) {
		EdgeDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		//click on CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();

		//click on contacts button
		driver.findElement(By.linkText("Contacts")).click();
		
		//click on Merge contacts using Xpath
		driver.findElement(By.xpath("//*[@id=\"left-content-column\"]/div/div[2]/ul/li[4]/a")).click();
		
		//click on widget in from contact
		driver.findElement(By.xpath("//div/form/table/tbody/tr[1]/td[2]/a/img")).click();
		
		//click on first resulting contact
		String fromContact = driver.getWindowHandle();
		driver.switchTo().window(fromContact);
		driver.findElement(By.xpath("//div/div/div/table/tbody/tr/td/div/a[text()=\"10963\"]")).click();
		
		
		//click on the widget for To contact
		driver.findElement(By.xpath("//div/form/table/tbody/tr[2]/td[2]/a/img")).click();
		
		//click on the first resulting contact
		String toContact = driver.getWindowHandle();
		driver.switchTo().window(toContact);
		driver.findElement(By.xpath("//div/table/tbody/tr/td/div/a[text()=\"10963\"]")).click();
		
	}

}
