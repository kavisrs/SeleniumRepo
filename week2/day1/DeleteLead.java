package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class DeleteLead {

	public static void main(String[] args) {
		//		ChromeOptions options = new ChromeOptions();
		//		options.addArguments("--remote-allow-origins=*");
		//		ChromeDriver driver = new ChromeDriver(options);B
		//		driver.get("http://leaftaps.com/opentaps");

		EdgeDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps");

		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		//click on CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();

		//click on Leads
		driver.findElement(By.linkText("Leads")).click();

		//click on Create Lead
		driver.findElement(By.linkText("Create Lead")).click();

		//Enter Company name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");

		//Enter First name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Kavitha");

		//Enter Last name
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Ratheesh");

		//Enter First name (local)
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("KR");

		//Enter Department Field - any locator
		driver.findElement(By.name("departmentName")).sendKeys("Testing");

		//Enter Description field - any locator
		driver.findElement(By.name("description")).sendKeys("Manual Testing");

		//Enter email - any locator
		driver.findElement(By.name("primaryEmail")).sendKeys("test@gmail.com");

		//Select state as Newyork using visible text
		WebElement stateProvnce = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select ddValue = new Select(stateProvnce);
		ddValue.selectByVisibleText("New York");

		//click create button
		driver.findElement(By.name("submitButton")).click();

		//to get the title
		String CreateTitle = driver.getTitle();
		System.out.println("Retrieving title 1st time : " +CreateTitle);

		//click duplicate 
		driver.findElement(By.linkText("Duplicate Lead")).click();

		//Clear company name and Enter new company name
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Infy");

		//Clear First name and enter new name
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("KR");

		//click create
		driver.findElement(By.className("smallSubmit")).click();


		//to get the title
		String resultPage = driver.getTitle();
		System.out.println("Retrieving title 2nd time:  "+resultPage);






	}


}

